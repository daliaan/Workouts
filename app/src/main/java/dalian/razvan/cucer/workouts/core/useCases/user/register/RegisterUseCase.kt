package dalian.razvan.cucer.workouts.core.useCases.user.register

import dalian.razvan.cucer.workouts.screens.login.LoginFragmentView
import dalian.razvan.cucer.workouts.screens.register.RegisterFragmentView

interface RegisterUseCase {
    fun canMakeRequest(registerScreen: RegisterFragmentView): Boolean
}