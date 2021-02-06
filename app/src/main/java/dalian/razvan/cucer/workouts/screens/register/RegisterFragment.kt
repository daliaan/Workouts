package dalian.razvan.cucer.workouts.screens.register

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import dalian.razvan.cucer.workouts.screens.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment: BaseFragment(), RegisterFragmentView {

    private val viewModel by viewModel<RegisterViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_register
    override fun getTitle(): Int = R.string.register

    override fun showToolbar(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username_input_field.set(WorkoutsInputFieldType.USERNAME)
        email_input_field.set(WorkoutsInputFieldType.EMAIL)
        password_input_field.set(WorkoutsInputFieldType.PASSWORD)
        confirm_password_input_field.set(WorkoutsInputFieldType.CONFIRM_PASSWORD, isLast = true)

        register.setOnClickListener {
            viewModel.register(this)
        }
    }

    override fun onResume() {
        super.onResume()

        username_input_field.error = ""
        email_input_field.error = ""
        password_input_field.error = ""
        confirm_password_input_field.error = ""
    }

    override fun getUsername(): String = username_input_field.value()
    override fun getEmail(): String = email_input_field.value()
    override fun getPassword(): String = password_input_field.value()
    override fun getConfirmPassword(): String = confirm_password_input_field.value()

    override fun validateUsername(): Boolean = username_input_field.validate()
    override fun validateEmail(): Boolean = email_input_field.validate()
    override fun validatePassword(): Boolean = password_input_field.validate()
    override fun validateConfirmPassword(): Boolean = confirm_password_input_field.validate()

    override fun hasAgreedToTerms(): Boolean = terms.isChecked

    override fun goToHomepage() {
        view?.let {
            Navigation.findNavController(it).popBackStack()
            Navigation.findNavController(it).navigate(R.id.goToHome)
        }
    }

    override fun successfulRegister() {
        showPopup(getString(R.string.successful_register), { dialogInterface, which ->
            goToHomepage()
        }, { dialogInterface ->
            goToHomepage()
        })
    }
}