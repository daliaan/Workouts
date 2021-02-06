package dalian.razvan.cucer.workouts.customViews.inputField

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dalian.razvan.cucer.workouts.R

class WorkoutsInputField: TextInputLayout, TextView.OnEditorActionListener, View.OnFocusChangeListener, TextWatcher {

    private var isValid: Boolean = true
    private lateinit var fieldType: WorkoutsInputFieldType
    private val textInputLayout: TextInputLayout
    private val textInputEditText: TextInputEditText

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.workouts_input_field, this, true)
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.text_input_edit_text)
    }

    override fun setError(errorText: CharSequence?) {
        super.setError("")
        super.setError(errorText)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(this.windowToken, 0)
            textInputEditText.clearFocus()
        }
        return false
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, EditorInfo.IME_ACTION_NEXT))
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {
        validate()
    }

    fun set(fieldType: WorkoutsInputFieldType, value: String = "", isLast: Boolean = false) {

        this.fieldType = fieldType

        textInputLayout.hint = getCorrectHint(fieldType)

        textInputEditText.setText(value)
        textInputEditText.inputType = getInputType(fieldType)
        textInputEditText.onFocusChangeListener = this
        textInputEditText.setOnEditorActionListener(this)
        textInputEditText.addTextChangedListener(this)
        textInputEditText.imeOptions = if (isLast) EditorInfo.IME_ACTION_DONE else EditorInfo.IME_ACTION_NEXT

        error = ""

        if (fieldType == WorkoutsInputFieldType.PASSWORD || fieldType == WorkoutsInputFieldType.CONFIRM_PASSWORD)
            textInputEditText.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun getCorrectHint(fieldType: WorkoutsInputFieldType): CharSequence? {
        return when(fieldType) {
            WorkoutsInputFieldType.NONE -> null
            WorkoutsInputFieldType.USERNAME -> resources.getString(R.string.username_hint)
            WorkoutsInputFieldType.EMAIL -> resources.getString(R.string.email_hint)
            WorkoutsInputFieldType.PASSWORD -> resources.getString(R.string.password_hint)
            WorkoutsInputFieldType.CONFIRM_PASSWORD -> resources.getString(R.string.confirm_password_hint)
            WorkoutsInputFieldType.WORKOUT_NAME -> resources.getString(R.string.workout_name_hint)
            WorkoutsInputFieldType.BURNED_CALORIES -> resources.getString(R.string.burned_calories_hint)
            WorkoutsInputFieldType.WORKOUT_DURATION -> resources.getString(R.string.workout_duration_hint)
            WorkoutsInputFieldType.DATE_OF_WORKOUT -> resources.getString(R.string.workout_date_hint)
        }
    }

    private fun getInputType(fieldType: WorkoutsInputFieldType): Int {
        return when(fieldType) {
            WorkoutsInputFieldType.USERNAME, WorkoutsInputFieldType.WORKOUT_NAME, WorkoutsInputFieldType.WORKOUT_DURATION -> InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            WorkoutsInputFieldType.EMAIL -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            WorkoutsInputFieldType.BURNED_CALORIES -> InputType.TYPE_CLASS_NUMBER
            WorkoutsInputFieldType.PASSWORD, WorkoutsInputFieldType.CONFIRM_PASSWORD -> InputType.TYPE_TEXT_VARIATION_PASSWORD
            else -> InputType.TYPE_CLASS_TEXT
        }
    }

    fun value(): String {
        return textInputEditText.text.toString()
    }

    fun validate(): Boolean {
        isValid = value().isNotEmpty() && value().isNotBlank()

        if (isValid) {
            error = ""
        } else {
            showCorrectError()
        }

        return isValid
    }

    private fun showCorrectError() {
        when(fieldType) {
            WorkoutsInputFieldType.USERNAME -> resources.getString(R.string.username_not_valid)
            WorkoutsInputFieldType.EMAIL -> error = resources.getString(R.string.email_not_valid)
            WorkoutsInputFieldType.PASSWORD -> error = resources.getString(R.string.password_not_valid)
            WorkoutsInputFieldType.CONFIRM_PASSWORD -> error = resources.getString(R.string.confirm_password_not_valid)
            else -> error = ""
        }
    }
}