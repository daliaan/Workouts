package dalian.razvan.cucer.workouts.screens.register

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment: BaseFragment() {

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
            Navigation.findNavController(view).popBackStack()
            Navigation.findNavController(view).navigate(R.id.goToHome)
        }
    }
}