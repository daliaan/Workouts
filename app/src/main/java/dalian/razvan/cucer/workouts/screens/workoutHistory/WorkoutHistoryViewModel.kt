package dalian.razvan.cucer.workouts.screens.workoutHistory

import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.data.repository.workout.WorkoutRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase
import dalian.razvan.cucer.workouts.core.useCases.workout.workoutHistory.WorkoutHistoryUseCase

class WorkoutHistoryViewModel(useCase: WorkoutHistoryUseCase, repository: WorkoutRepository): BaseViewModel() {
}