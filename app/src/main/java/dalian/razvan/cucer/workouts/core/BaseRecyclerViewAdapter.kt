package dalian.razvan.cucer.workouts.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<VH : BaseRecyclerViewHolder> : RecyclerView.Adapter<VH>(){

    protected abstract fun getItem(position : Int) : BaseModelView
    abstract fun clear() //this method only if we need to clear more than the list; if not the Adapter class already has it
    abstract fun addHolderOnClickListener(onClickListener: View.OnClickListener)
}