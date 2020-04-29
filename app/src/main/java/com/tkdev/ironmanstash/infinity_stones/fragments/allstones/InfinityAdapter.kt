package com.tkdev.ironmanstash.infinity_stones.fragments.allstones

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.R

class InfinityAdapter(private val context: Context, private val infinityStones: List<InfinityStone>) : RecyclerView.Adapter<InfinityViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): InfinityViewHolder {
        return InfinityViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_container, viewGroup, false))
    }

    override fun getItemCount(): Int = infinityStones.size


    override fun onBindViewHolder(infinityViewHolder: InfinityViewHolder, position: Int) {
        infinityViewHolder.setHolder(infinityStones[position])
    }


}