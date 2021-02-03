package dalian.razvan.cucer.workouts.screens.login

import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase

class LoginViewModel(useCase: LoginUseCase, repository: UserRepository): BaseViewModel() {
}