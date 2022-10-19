package com.example.beers.entities

import com.example.beers.ui.ListItemViewModel
import com.squareup.moshi.Json

class DSBeer(
    val id: String = "",
    val name: String = "",
    val tagline: String = "",
    val firstBrewed: String = "",
    val description: String = "",
    val imageUrl: String = "")  : ListItemViewModel() {
}