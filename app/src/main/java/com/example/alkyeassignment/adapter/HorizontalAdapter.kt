package com.example.alkyeassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.databinding.ItemListHorizontalBinding
import com.example.alkyeassignment.model.DetailData

class HorizontalAdapter(private var dataList: List<DetailData>): RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemListHorizontalBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        var limit: Int = 3
        return limit
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        //holder.binding.txtData.text = currentItem.data
        holder.binding.txtDate.text = currentItem.date
    }
}