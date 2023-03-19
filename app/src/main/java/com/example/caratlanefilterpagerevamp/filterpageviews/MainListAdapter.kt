package com.example.caratlanefilterpagerevamp.filterpageviews

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.caratlanefilterpagerevamp.MainItemsViewModel
import com.example.caratlanefilterpagerevamp.R
import com.example.caratlanefilterpagerevamp.filterpageviewmodel.SubListViewModel

class MainListAdapter(
    private val mList: List<MainItemsViewModel>,
    private val viewModel: SubListViewModel
) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {
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
            viewModel.selectedPosition = selectedPosition
            viewModel.refreshCheckedCount()
        }
        viewModel.checkedCount.observe((holder.itemView.context as FragmentActivity)) { count ->
            if (viewModel.selectedPosition == position){
                holder.circularTextView.text = count.toString()
                holder.circularTextView.isVisible = true
            }
            else{
                holder.circularTextView.text = "0"
                holder.circularTextView.isVisible = false
            }
            Log.d("Aish", "onBindViewHolder: $count")
        }

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var textView: TextView = itemView.findViewById(R.id.textView)
        var  circularTextView : TextView = itemView.findViewById(R.id.circle_main_list)
    }
    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }
}
