package dalian.razvan.cucer.workouts.screens.workoutHistory

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import kotlinx.android.synthetic.main.fragment_workout_detail.*
import kotlinx.android.synthetic.main.fragment_workout_history.*

class WorkoutHistoryFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_workout_history
    override fun getTitle(): Int = R.string.workout_history

    override fun showToolbar(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_new_workout.drawable.mutate().colorFilter = PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        add_new_workout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goToAddNewWorkout)
        }
    }
}