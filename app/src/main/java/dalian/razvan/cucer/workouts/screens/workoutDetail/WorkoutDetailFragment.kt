package dalian.razvan.cucer.workouts.screens.workoutDetail

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel

class WorkoutDetailFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_workout_detail
    override fun getTitle(): Int = 0//TODO change with workout title

    override fun showHomeAsUp(): Boolean = false
    override fun homeAsUpEnabled(): Boolean = false
    override fun showToolbar(): Boolean = true
}