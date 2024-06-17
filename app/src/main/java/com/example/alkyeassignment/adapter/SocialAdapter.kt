package com.example.alkyeassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.databinding.ItemListSocialBinding
import com.example.alkyeassignment.model.DetailData

class SocialAdapter(private val dataList: List<DetailData>): RecyclerView.Adapter<SocialAdapter.viewHolder>() {
    class viewHolder(val binding: ItemListSocialBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       val binding = ItemListSocialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
       val limit: Int = 3
        return limit
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.binding.txtData.text = currentItem.social
    }
}