package dalian.razvan.cucer.workouts.screens.addNewWorkout

import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragmentView

interface AddNewWorkoutFragmentView: BaseFragmentView {

    fun getWorkoutName(): String
    fun getBurnedCalories(): String
    fun getWorkoutDuration(): String
    fun getWorkoutDate(): String

    fun validateWorkoutName(): Boolean
    fun validateBurnedCalories(): Boolean
    fun validateWorkoutDuration(): Boolean
    fun validateWorkoutDate(): Boolean

    fun goToHomepage()
}
