package com.example.newsapplicationwithviewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter( private var userList: List<MyDataItem>):

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    var mCallBackToFragmentListener : CallBackToFragmentListener ?= null
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var date: TextView
        var head: TextView
        var image: AppCompatImageView
        var layout: ConstraintLayout

        init{
            date = itemView.findViewById(R.id.date)
            head = itemView.findViewById(R.id.tv_heading)
            image = itemView.findViewById(R.id.title_image)
            layout = itemView.findViewById(R.id.item_layout)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = userList[position].date.toString()
        holder.head.text = userList[position].head.toString()
        holder.layout.setOnClickListener {
            mCallBackToFragmentListener?.callBack(userList[position].image.toString(),userList[position].news.toString())
        }
        val dataItem = userList[position]
        Glide.with(holder.itemView.context)
            .load(dataItem.image)
            .into(holder.image)
    }
    override fun getItemCount(): Int {
        return userList.size
    }

    fun setCallBackListener(callBackToFragmentListener: CallBackToFragmentListener){
        this.mCallBackToFragmentListener = callBackToFragmentListener
    }






}
