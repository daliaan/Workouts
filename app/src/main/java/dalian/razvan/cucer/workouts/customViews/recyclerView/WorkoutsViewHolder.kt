package dalian.razvan.cucer.workouts.customViews.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseRecyclerViewHolder
import dalian.razvan.cucer.workouts.models.workout.WorkoutModelViewImpl
import kotlinx.android.synthetic.main.workout_row.view.*

class WorkoutsViewHolder(itemView: View): BaseRecyclerViewHolder<WorkoutModelViewImpl>(itemView) {

    private val workoutImage = itemView.findViewById<ImageView>(R.id.workout_image)
    private val workoutName = itemView.findViewById<TextView>(R.id.workout_name)
    private val workoutDate = itemView.findViewById<TextView>(R.id.workout_date)

    override fun bind(interfaceImplementation: WorkoutModelViewImpl) {
        workoutImage.load(interfaceImplementation.getPhotoBitmap())
        workoutName.text = interfaceImplementation.getWorkoutName()
        workoutDate.text = interfaceImplementation.getWorkoutDate()
    }

    override fun setOnClickListener(onClickListener: View.OnClickListener?) {
        itemView.setOnClickListener(onClickListener)
    }
}