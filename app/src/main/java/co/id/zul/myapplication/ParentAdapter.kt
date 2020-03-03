package co.id.zul.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem

open class ParentAdapter(private val dataModel: String) :
    AbstractExpandableItem<ParentAdapter.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.item_parent

    override val type: Int
        get() = R.id.item_parent_complaint_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.textViewDate.text = dataModel
    }

    override fun unbindView(holder: ViewHolder) {
        super.unbindView(holder)
        holder.textViewDate.text = null
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate: TextView = view.findViewById(R.id.textView_date_item_list)
    }

}