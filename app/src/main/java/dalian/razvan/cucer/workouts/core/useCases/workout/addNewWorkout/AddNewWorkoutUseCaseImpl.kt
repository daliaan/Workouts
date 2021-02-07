package dalian.razvan.cucer.workouts.core.useCases.workout.addNewWorkout

import dalian.razvan.cucer.workouts.screens.addNewWorkout.AddNewWorkoutFragmentView

class AddNewWorkoutUseCaseImpl: AddNewWorkoutUseCase {
    override fun canMakeRequest(addNewWorkoutScreen: AddNewWorkoutFragmentView): Boolean {
        var isValid = true

        if (!addNewWorkoutScreen.validateBurnedCalories()) {
            isValid = false
        }

        if (!addNewWorkoutScreen.validateWorkoutDuration()) {
            isValid = false
        }

        if (!addNewWorkoutScreen.validateWorkoutDate()) {
            isValid = false
        }

        return isValid
    }
}