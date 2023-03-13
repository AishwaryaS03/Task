package com.example.caratlanefilterpagerevamp.filterpageviews

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caratlanefilterpagerevamp.filterpagedataclass.ItemsViewModelSubList
import com.example.caratlanefilterpagerevamp.R

class SubListAdapter(private val mList: List<ItemsViewModelSubList>) : RecyclerView.Adapter<SubListAdapter.ViewHolder>() {

    private var checkedCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sub_list_view_design, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModelTwo = mList[position]
        holder.textView.text = itemViewModelTwo.text
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            checkedCount += if (isChecked) 1 else -1
            Log.d("Aish", "onBindViewHolder: $checkedCount")
            //    (holder.itemView.context as MainActivity).updateCheckedCount(checkedCount)
            //     notifyItemChanged(checkedCount)

        }
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val checkBox: CheckBox = itemView.findViewById(R.id.itemCheckBox)
    }
}
