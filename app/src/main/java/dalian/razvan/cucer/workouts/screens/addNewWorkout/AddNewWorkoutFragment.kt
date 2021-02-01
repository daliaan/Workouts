package dalian.razvan.cucer.workouts.screens.addNewWorkout

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.BaseFragment
import dalian.razvan.cucer.workouts.core.BaseViewModel

class AddNewWorkoutFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_add_new_workout
    override fun getTitle(): Int = R.string.add_new_workout

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