package dalian.razvan.cucer.workouts.screens.addNewWorkout

import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.workout.WorkoutRepository
import dalian.razvan.cucer.workouts.core.useCases.workout.addNewWorkout.AddNewWorkoutUseCase
import dalian.razvan.cucer.workouts.models.workout.Workout

class AddNewWorkoutViewModel(var useCase: AddNewWorkoutUseCase, var repository: WorkoutRepository): BaseViewModel() {
    fun addNewWorkout(addNewWorkoutScreen: AddNewWorkoutFragmentView) {
        if (useCase.canMakeRequest(addNewWorkoutScreen)) {
            repository.addNewWorkout(generateWorkout(addNewWorkoutScreen))
        }
    }

    private fun generateWorkout(addNewWorkoutScreen: AddNewWorkoutFragmentView): Workout
        = Workout(workoutName = addNewWorkoutScreen.getWorkoutName(),
                  workoutDuration = addNewWorkoutScreen.getWorkoutDuration(),
                  burnedCalories = addNewWorkoutScreen.getBurnedCalories(),
                  workoutDate = addNewWorkoutScreen.getWorkoutDate(),
                  photo = null)
}