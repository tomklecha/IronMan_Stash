package com.tkdev.ironmanstash.infinity_stones.fragments.allstones

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_container.view.*

class InfinityViewHolder(holderView: View) : RecyclerView.ViewHolder(holderView) {
    private val stoneImageView: ImageView = holderView.recyclerStoneImage
    private val stoneTextView: TextView = holderView.recyclerStoneName

    fun setHolder(holderView: InfinityStone): InfinityViewHolder {

        stoneImageView.setImageResource(holderView.imageId)
        stoneImageView.alpha = 0.3f
        if (holderView.isVisible == 0) {
            stoneImageView.animate().alpha(1f).duration = 2000;
        }
        stoneTextView.text = holderView.stoneName

        return this
    }
}