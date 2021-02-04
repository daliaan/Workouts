package dalian.razvan.cucer.workouts.customViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseModelView
import dalian.razvan.cucer.workouts.core.baseClasses.BaseRecyclerViewAdapter
import dalian.razvan.cucer.workouts.models.workout.Workout
import dalian.razvan.cucer.workouts.models.workout.WorkoutModelViewImpl

class WorkoutsAdapter: BaseRecyclerViewAdapter<WorkoutModelViewImpl, WorkoutsViewHolder>() {

    private var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutsViewHolder
            = WorkoutsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.workout_row, parent, false))

    override fun onBindViewHolder(holder: WorkoutsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.setOnClickListener(onClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun getItem(position: Int): WorkoutModelViewImpl = items[position]

    override fun addHolderOnClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }

    override fun setList(items: ArrayList<WorkoutModelViewImpl>) {
        this.items.clear()
        this.items.addAll(items)
    }
}