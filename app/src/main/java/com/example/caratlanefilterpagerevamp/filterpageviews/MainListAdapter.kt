package com.example.caratlanefilterpagerevamp.filterpageviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.caratlanefilterpagerevamp.MainItemsViewModel
import com.example.caratlanefilterpagerevamp.R

class MainListAdapter(private val mList: List<MainItemsViewModel>) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    private var itemClickListener: ((Int) -> Unit)? = null
    private var selectedPosition = RecyclerView.NO_POSITION
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list_view_design, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.text
        holder.itemView.setBackgroundResource(R.drawable.recycler_view_item_divider)
        holder.itemView.isSelected = selectedPosition == position
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(position)
            notifyItemChanged(selectedPosition)
            selectedPosition = position
            notifyItemChanged(selectedPosition)
        }

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var textView: TextView = itemView.findViewById(R.id.textView)
    }
    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }



}
