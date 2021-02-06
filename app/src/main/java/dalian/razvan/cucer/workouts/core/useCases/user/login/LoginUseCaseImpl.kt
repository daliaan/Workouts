package dalian.razvan.cucer.workouts.core.useCases.user.login

import dalian.razvan.cucer.workouts.screens.login.LoginFragmentView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginUseCaseImpl: LoginUseCase {
    override fun canMakeRequest(loginScreen: LoginFragmentView): Boolean {
        var isValid = true

        if (!loginScreen.validateEmail()) {
            isValid = false
        }

        if(!loginScreen.validatePassword()) {
            isValid = false
        }

        return isValid
    }
}