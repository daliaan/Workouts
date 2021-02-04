package dalian.razvan.cucer.workouts.screens.workoutHistory

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel

class WorkoutHistoryFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_workout_history
    override fun getTitle(): Int = R.string.workout_history

    override fun showToolbar(): Boolean = true
}