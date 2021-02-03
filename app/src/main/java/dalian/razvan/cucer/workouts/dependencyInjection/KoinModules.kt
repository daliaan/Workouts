package dalian.razvan.cucer.workouts.dependencyInjection

import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepositoryImpl
import dalian.razvan.cucer.workouts.core.data.repository.workout.WorkoutRepository
import dalian.razvan.cucer.workouts.core.data.repository.workout.WorkoutRepositoryImpl
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCaseImpl
import dalian.razvan.cucer.workouts.core.useCases.user.register.RegisterUseCase
import dalian.razvan.cucer.workouts.core.useCases.user.register.RegisterUseCaseImpl
import dalian.razvan.cucer.workouts.core.useCases.workout.addNewWorkout.AddNewWorkoutUseCase
import dalian.razvan.cucer.workouts.core.useCases.workout.addNewWorkout.AddNewWorkoutUseCaseImpl
import dalian.razvan.cucer.workouts.core.useCases.workout.workoutHistory.WorkoutHistoryUseCase
import dalian.razvan.cucer.workouts.core.useCases.workout.workoutHistory.WorkoutHistoryUseCaseImpl
import dalian.razvan.cucer.workouts.screens.addNewWorkout.AddNewWorkoutViewModel
import dalian.razvan.cucer.workouts.screens.login.LoginViewModel
import dalian.razvan.cucer.workouts.screens.register.RegisterViewModel
import dalian.razvan.cucer.workouts.screens.splash.SplashViewModel
import dalian.razvan.cucer.workouts.screens.workoutDetail.WorkoutDetailViewModel
import dalian.razvan.cucer.workouts.screens.workoutHistory.WorkoutHistoryViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single { RegisterUseCaseImpl() as RegisterUseCase }
    single { LoginUseCaseImpl() as LoginUseCase }
    single { AddNewWorkoutUseCaseImpl() as AddNewWorkoutUseCase }
    single { WorkoutHistoryUseCaseImpl() as WorkoutHistoryUseCase }
}

val repositoryModule = module {
    single { UserRepositoryImpl() as UserRepository }
    single { WorkoutRepositoryImpl() as WorkoutRepository }
}

val viewModelsModule = module {
    viewModel { AddNewWorkoutViewModel(get(), get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get()) }
    viewModel { SplashViewModel() }
    viewModel { WorkoutDetailViewModel(get()) }
    viewModel { WorkoutHistoryViewModel(get(), get()) }
}

val networkModule = module {

}

val serviceModule = module {

}