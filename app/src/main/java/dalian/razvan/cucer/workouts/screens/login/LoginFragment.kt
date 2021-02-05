package dalian.razvan.cucer.workouts.screens.login

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment(), View.OnClickListener, LoginFragmentView {

    private val viewModel by viewModel<LoginViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_login
    override fun getTitle(): Int = R.string.login

    override fun showToolbar(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email_input_field.set(WorkoutsInputFieldType.EMAIL)
        password_input_field.set(WorkoutsInputFieldType.PASSWORD, isLast = true)

        login.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        email_input_field.error = ""
        password_input_field.error = ""
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.login -> {
                if (email_input_field.validate() && password_input_field.validate())
                    viewModel.login(this)
                else {
                    var error = ""
                    if (!email_input_field.validate()) {
                        error += resources.getString(R.string.email_not_valid)
                        error += "\n"
                    }
                    if (!password_input_field.validate()) {
                        error += resources.getString(R.string.password_not_valid)
                    }
                    showPopup(error)
                }

            }
            R.id.register -> {
                goToRegister(view)
            }
            else -> {}
        }
    }

    override fun getEmail(): String {
        return email_input_field.value()
    }

    override fun getPassword(): String {
        return password_input_field.value()
    }

    override fun goToRegister(v: View) {
        Navigation.findNavController(v).popBackStack()
        Navigation.findNavController(v).navigate(R.id.goToRegister)
    }

    override fun goToHomepage() {
        view?.let {
            Navigation.findNavController(it).popBackStack()
            Navigation.findNavController(it).navigate(R.id.goToRegister)
        }
    }
}