package dalian.razvan.cucer.workouts.core.baseClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<T: BaseModelView>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    abstract fun setOnClickListener(onClickListener: View.OnClickListener)
    abstract fun  bind(interfaceImplementation: T)
}