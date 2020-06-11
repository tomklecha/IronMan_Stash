package com.tkdev.ironmanstash.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import kotlinx.android.synthetic.main.recycler_view_container.view.*

class InfinityStonesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val stoneImageView: ImageView = itemView.recyclerStoneImage
    private val stoneTextView: TextView = itemView.recyclerStoneName

    fun setHolder(holderView: InfinityStoneEntity): InfinityStonesViewHolder {

        stoneImageView.setImageResource(holderView.image)
        stoneImageView.alpha = 0.3f
        if (holderView.isVisible) {
            stoneImageView.animate().alpha(1f).duration = 2000;
        }
        stoneTextView.text = holderView.name

        return this
    }


}