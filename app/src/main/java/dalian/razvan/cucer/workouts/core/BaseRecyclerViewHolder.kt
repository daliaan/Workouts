package dalian.razvan.cucer.workouts.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    public abstract fun setOnClickListener(onClickListener: View.OnClickListener)
    public abstract fun bind(interfaceImplementation: BaseModelView)
}