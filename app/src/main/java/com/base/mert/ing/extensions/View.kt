package com.base.mert.ing.extensions

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:visibility")
fun View.setVisibility(boolean: Boolean?) = takeIf { boolean != null }?.let {
    if(boolean == true) this.visibility = View.VISIBLE else this.visibility = View.GONE
}

@BindingAdapter("auto:imageDrawable")
fun AppCompatImageView.setImageDrawable(url: String?) = takeUnless { url.isNullOrBlank() }?.let {
    Glide.with(context)
            .load(url)
            .into(this)
}