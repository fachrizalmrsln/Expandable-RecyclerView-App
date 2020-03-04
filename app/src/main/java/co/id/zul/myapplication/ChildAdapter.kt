package co.id.zul.myapplication

import android.view.View
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.ClickListener
import com.mikepenz.fastadapter.IClickable
import com.mikepenz.fastadapter.ISubItem
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

class ChildAdapter(private val description: DataModel) :
    AbstractExpandableItem<ChildAdapter.ViewHolder>(),
    ISubItem<ChildAdapter.ViewHolder>,
    IClickable<ChildAdapter> {

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

    override var onItemClickListener: ClickListener<ChildAdapter>? = { v, adapter, item, position ->
        if (item.subItems.isNotEmpty()) {
            v?.findViewById<View>(R.id.imageView_expand_more_item_child)?.let {
                if (item.isExpanded) {
                    ViewCompat.animate(it).rotation(180f).start()
                } else {
                    ViewCompat.animate(it).rotation(0f).start()
                }
            }
        }
        true
    }

    override var onPreItemClickListener: ClickListener<ChildAdapter>?
        get() = null
        set(value) {}

}