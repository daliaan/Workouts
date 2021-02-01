package dalian.razvan.cucer.core.baseClasses.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.core.baseClasses.BaseModelView

abstract class BaseRecyclerViewAdapter<VH : BaseRecyclerViewHolder> : RecyclerView.Adapter<VH>(){

    protected abstract fun getItem(position : Int) : BaseModelView
    abstract fun clear() //this method only if we need to clear more than the list; if not the Adapter class already has it
    abstract fun addHolderOnClickListener(onClickListener: View.OnClickListener)
}