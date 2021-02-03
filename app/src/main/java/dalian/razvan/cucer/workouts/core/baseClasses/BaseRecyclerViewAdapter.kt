package dalian.razvan.cucer.workouts.core.baseClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T: BaseModelView,VH : BaseRecyclerViewHolder<T>> : RecyclerView.Adapter<VH>(){

    protected abstract fun getItem(position : Int) : BaseModelView
    abstract fun addHolderOnClickListener(onClickListener: View.OnClickListener)
}