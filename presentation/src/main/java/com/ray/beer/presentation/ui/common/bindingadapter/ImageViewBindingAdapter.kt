package com.ray.beer.presentation.ui.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ray.beer.presentation.R

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        setImageResource(R.drawable.ic_warning)
    } else {
        Glide.with(this.context)
            .load(imageUrl)
            .error(R.drawable.ic_warning)
            .into(this)
    }
}