package com.example.beers

import android.widget.ImageView
import android.widget.ListAdapter
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beers.entities.Beer

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            //placeholder(R.drawable.loading_animation)
            //error(R.drawable.ic_broken_image)
        }
    }
}