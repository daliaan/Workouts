package dalian.razvan.cucer.workouts.screens.workoutDetail

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import kotlinx.android.synthetic.main.fragment_workout_detail.*

class WorkoutDetailFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_workout_detail
    override fun getTitle(): Int = 0

    override fun showToolbar(): Boolean = true
}