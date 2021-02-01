package dalian.razvan.cucer.workouts.screens.workoutDetail

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.BaseFragment
import dalian.razvan.cucer.workouts.core.BaseViewModel

class WorkoutDetailFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_workout_detail
    override fun getTitle(): Int = 0//TODO change with workout title

    override fun showHomeAsUp(): Boolean = false
    override fun homeAsUpEnabled(): Boolean = false
    override fun showToolbar(): Boolean = true

    override fun getViewModelClass(): Class<out BaseViewModel> {
        TODO("Not yet implemented")
    }

    override fun getViewModelInstance(): BaseViewModel {
        TODO("Not yet implemented")
    }
}