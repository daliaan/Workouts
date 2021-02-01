package dalian.razvan.cucer.core.baseClasses.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dalian.razvan.cucer.core.baseClasses.BaseModelView

abstract class BaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    public abstract fun setOnClickListener(onClickListener: View.OnClickListener)
    public abstract fun bind(interfaceImplementation: BaseModelView)
}