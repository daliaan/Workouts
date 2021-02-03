package dalian.razvan.cucer.workouts.screens.register

import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase

class RegisterViewModel(useCase: LoginUseCase, repository: UserRepository): BaseViewModel() {
}