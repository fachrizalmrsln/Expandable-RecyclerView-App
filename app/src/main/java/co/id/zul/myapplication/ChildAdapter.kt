package co.id.zul.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.ISubItem
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

class ChildAdapter(private val description: DataModel) :
    AbstractExpandableItem<ChildAdapter.ViewHolder>(),
    ISubItem<ChildAdapter.ViewHolder> {

    override val layoutRes: Int
        get() = R.layout.item_child

    override val type: Int
        get() = R.id.item_child_complaint_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.textViewTitle.text = description.title
        holder.textViewSubtitle.text = description.subtitle
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        holder.textViewTitle.text = null
        holder.textViewSubtitle.text = null
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView = view.findViewById(R.id.textView_title_item_list)
        val textViewSubtitle: TextView = view.findViewById(R.id.textView_subtitle_item_list)
    }

}