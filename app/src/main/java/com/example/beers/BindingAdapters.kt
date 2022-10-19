package com.example.beers

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beers.entities.DSBeer
import com.example.beers.entities.DTOBeer
import com.example.beers.ui.GenericAdapter

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

@BindingAdapter("items")
fun bindRecyclerView(recyclerView: RecyclerView, data: MutableList<DSBeer>, ) {
    val adapter = GenericAdapter<DSBeer>(R.layout.item_beer)
    recyclerView.adapter = adapter
    adapter.addItems(data)
}



