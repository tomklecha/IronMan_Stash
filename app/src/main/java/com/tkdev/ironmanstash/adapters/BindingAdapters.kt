package com.tkdev.ironmanstash.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageResource")
fun setResourceId(view: ImageView, image: Int) {
    view.setImageResource(image)
    view.alpha = 0.3f
}

@BindingAdapter("setImageVisibility")
fun setImageVisibility(view: ImageView, visibility: Boolean) {
    if (visibility)
        view.animate().alpha(1f).duration = 2000
}
