package com.tkdev.ironmanstash.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.databinding.RecyclerViewContainerBinding

class InfinityStonesAdapter :
        ListAdapter<InfinityStoneEntity, RecyclerView.ViewHolder>(StoneDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InfinityStonesViewHolder(RecyclerViewContainerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as InfinityStonesViewHolder).setHolder(item)
    }
}

private class StoneDiffCallback : DiffUtil.ItemCallback<InfinityStoneEntity>() {

    override fun areItemsTheSame(oldItem: InfinityStoneEntity, newItem: InfinityStoneEntity): Boolean {
        //TODO check here this implementation
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: InfinityStoneEntity, newItem: InfinityStoneEntity): Boolean {
        return oldItem == newItem
    }
}