package dalian.razvan.cucer.workouts.core.useCases.workout.addNewWorkout

import dalian.razvan.cucer.workouts.screens.addNewWorkout.AddNewWorkoutFragmentView

interface AddNewWorkoutUseCase {
    fun canMakeRequest(addNewWorkoutScreen: AddNewWorkoutFragmentView): Boolean
}