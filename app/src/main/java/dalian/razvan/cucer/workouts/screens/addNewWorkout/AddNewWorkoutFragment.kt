package dalian.razvan.cucer.workouts.screens.addNewWorkout

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.customViews.inputField.WorkoutsInputFieldType
import kotlinx.android.synthetic.main.fragment_add_new_workout.*
import org.koin.android.viewmodel.ext.android.viewModel

class AddNewWorkoutFragment: BaseFragment(), AddNewWorkoutFragmentView {

    private val viewModel by viewModel<AddNewWorkoutViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_add_new_workout
    override fun getTitle(): Int = R.string.add_new_workout

    override fun showToolbar(): Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workout_name_input_field.set(WorkoutsInputFieldType.WORKOUT_NAME)
        burned_calories_input_field.set(WorkoutsInputFieldType.BURNED_CALORIES)
        workout_duration_input_field.set(WorkoutsInputFieldType.WORKOUT_DURATION)
        workout_date_button.set(WorkoutsInputFieldType.DATE_OF_WORKOUT, isLast = true)

        save_workout.setOnClickListener {
            viewModel.addNewWorkout(this)
        }
    }

    override fun getWorkoutName(): String = workout_name_input_field.value()
    override fun getBurnedCalories(): String = burned_calories_input_field.value()
    override fun getWorkoutDuration(): String = workout_duration_input_field.value()
    override fun getWorkoutDate(): String = workout_duration_input_field.value()

    override fun validateWorkoutName(): Boolean = workout_name_input_field.validate()
    override fun validateBurnedCalories(): Boolean = burned_calories_input_field.validate()
    override fun validateWorkoutDuration(): Boolean = workout_duration_input_field.validate()
    override fun validateWorkoutDate(): Boolean = workout_date_button.validate()

    override fun goToHomepage() {
        view?.let {
            Navigation.findNavController(it).popBackStack()
        }
    }
}