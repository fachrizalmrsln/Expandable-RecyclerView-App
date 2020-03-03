package co.id.zul.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

class GrandChildAdapter(private val description: DataModel) :
    AbstractExpandableItem<GrandChildAdapter.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_grandchild

    override val type: Int
        get() = R.id.item_grandchild_complaint_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.textViewDescription.text = description.description
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        holder.textViewDescription.text = null
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDescription: TextView = view.findViewById(R.id.textView_description_item_list)
    }

}