package com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

//@BindingAdapter("bind:imageUrl")

@BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        //Picasso.with(imageView.context).load(imageUrl).resize(200, 200).into(imageView)
    Picasso.get().load(url).resize(100,150).into(imageView)
    }
