package dalian.razvan.cucer.workouts.customViews.inputField

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dalian.razvan.cucer.workouts.R

class WorkoutsInputField: TextInputLayout {

    private val textInputLayout = findViewById<TextInputLayout>(R.id.text_input_layout)
    private val textInputEditText = findViewById<TextInputEditText>(R.id.text_input_edit_text)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.workouts_input_field, this)
    }
}