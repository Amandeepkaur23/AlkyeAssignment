package com.example.alkyeassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.databinding.ItemListVerticalBinding
import com.example.alkyeassignment.model.DetailData

class VerticalAdapter(private val dataList: List<DetailData>,
                      private val onclick: Boolean
): RecyclerView.Adapter<VerticalAdapter.viewHolder>() {
    class viewHolder(val binding: ItemListVerticalBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemListVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        val limit = 3
        if(onclick){
            return dataList.size
        }
        return limit
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = dataList[position]
        //holder.binding.txtData.text = currentItem.data
        holder.binding.txtDate.text = currentItem.date
    }
}