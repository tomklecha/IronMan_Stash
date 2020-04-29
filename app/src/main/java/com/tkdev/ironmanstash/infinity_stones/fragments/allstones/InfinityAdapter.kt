package com.tkdev.ironmanstash.infinity_stones.fragments.allstones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.R

class InfinityAdapter(private val context: Context, private val infinityStones: List<InfinityStone>) : RecyclerView.Adapter<InfinityAdapter.InfinityViewHolder>() {
    private val VISIBLE = 0
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): InfinityViewHolder {
        return InfinityViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_container, viewGroup, false))
    }

    override fun getItemCount(): Int = infinityStones.size


    override fun onBindViewHolder(infinityViewHolder: InfinityViewHolder, position: Int) {
        infinityViewHolder.stoneImageView.setImageResource(infinityStones[position].imageId)
        if (infinityStones[position].isVisible == VISIBLE) {
            infinityViewHolder.stoneImageView.animate().alpha(1f).duration = 2000
        }
        infinityViewHolder.stoneTextView.text = infinityStones[position].stoneName
    }

    inner class InfinityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stoneImageView: ImageView = view.findViewById(R.id.recycler_stone_image)

        val stoneTextView: TextView

        init {
            stoneImageView.alpha = 0.3f
            stoneTextView = view.findViewById(R.id.recycler_stone_name)
        }

    }

}