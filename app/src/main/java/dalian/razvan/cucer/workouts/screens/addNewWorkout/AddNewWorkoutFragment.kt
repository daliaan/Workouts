package dalian.razvan.cucer.workouts.screens.addNewWorkout

import android.os.Bundle
import android.view.View
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import kotlinx.android.synthetic.main.fragment_add_new_workout.*

class AddNewWorkoutFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_add_new_workout
    override fun getTitle(): Int = R.string.add_new_workout

    override fun showToolbar(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workout_name_input_field.set(WorkoutsInputFieldType.WORKOUT_NAME)
        burned_calories_input_field.set(WorkoutsInputFieldType.BURNED_CALORIES)
        workout_duration_input_field.set(WorkoutsInputFieldType.WORKOUT_DURATION)
        workout_date_button.set(WorkoutsInputFieldType.DATE_OF_WORKOUT, isLast = true)


    }
}