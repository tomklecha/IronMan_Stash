package com.tkdev.ironmanstash.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class InfinityStonesAdapter internal constructor(context: Context) : RecyclerView.Adapter<InfinityStonesViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var stones = emptyList<InfinityStoneEntity>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): InfinityStonesViewHolder {
        return InfinityStonesViewHolder(inflater.inflate(R.layout.recycler_view_container, viewGroup, false))
    }

    override fun getItemCount(): Int = stones.size

    internal fun setStones(stones: List<InfinityStoneEntity>) {
        this.stones = stones
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(infinityViewHolder: InfinityStonesViewHolder, position: Int) {
        infinityViewHolder.setHolder(stones[position])
    }


}