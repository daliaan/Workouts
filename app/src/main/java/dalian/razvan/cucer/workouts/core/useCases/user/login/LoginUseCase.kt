package dalian.razvan.cucer.workouts.core.useCases.user.login

import dalian.razvan.cucer.workouts.screens.login.LoginFragmentView

interface LoginUseCase {
    fun canMakeRequest(loginScreen: LoginFragmentView): Boolean
}