package dalian.razvan.cucer.workouts.core.baseClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.workouts.models.workout.WorkoutModelViewImpl

abstract class BaseRecyclerViewAdapter<T: BaseModelView,VH : BaseRecyclerViewHolder<T>> : RecyclerView.Adapter<VH>(){

    protected var items = arrayListOf<T>()

    protected abstract fun getItem(position : Int) : BaseModelView
    abstract fun addHolderOnClickListener(onClickListener: View.OnClickListener)
    abstract fun setList(items: ArrayList<T>)
}