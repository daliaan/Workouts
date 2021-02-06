package dalian.razvan.cucer.workouts.core.useCases.user.register

import dalian.razvan.cucer.workouts.screens.register.RegisterFragmentView
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterUseCaseImpl: RegisterUseCase {
    override fun canMakeRequest(registerScreen: RegisterFragmentView): Boolean {
        var isValid = true

        if (!registerScreen.validateUsername()) {
            isValid = false
        }

        if (!registerScreen.validateEmail()) {
            isValid = false
        }

        if (!registerScreen.validatePassword()) {
            isValid = false
        }

        if (!registerScreen.validateConfirmPassword()) {
            isValid = false
        } else if (registerScreen.getPassword() != registerScreen.getConfirmPassword()) {
            isValid = false
        }

        return isValid
    }
}