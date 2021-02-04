package dalian.razvan.cucer.workouts.screens.addNewWorkout

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel

class AddNewWorkoutFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_add_new_workout
    override fun getTitle(): Int = R.string.add_new_workout

    override fun showToolbar(): Boolean = true
}