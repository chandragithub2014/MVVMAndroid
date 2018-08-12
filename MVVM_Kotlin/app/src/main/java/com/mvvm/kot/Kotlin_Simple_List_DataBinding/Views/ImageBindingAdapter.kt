package com.mvvm.kot.Kotlin_Simple_List_DataBinding.Views

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

//@BindingAdapter("bind:imageUrl")

@BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource);
    }
