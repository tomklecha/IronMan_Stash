package com.tkdev.ironmanstash.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.databinding.RecyclerViewContainerBinding
import kotlinx.android.synthetic.main.recycler_view_container.view.*

class InfinityStonesViewHolder(private val binding: RecyclerViewContainerBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun setHolder(holderView: InfinityStoneEntity) {
        binding.apply {
            stone = holderView
            executePendingBindings()
        }
    }

}