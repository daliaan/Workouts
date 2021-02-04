package dalian.razvan.cucer.workouts.screens.login

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseFragment(), View.OnClickListener {

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

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.login -> {

            }
            R.id.register -> {
                Navigation.findNavController(view).popBackStack()
                Navigation.findNavController(view).navigate(R.id.goToRegister)
            }
            else -> {}
        }
    }
}