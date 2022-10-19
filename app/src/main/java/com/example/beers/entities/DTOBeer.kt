package com.example.beers.entities

import com.example.beers.ui.ListItemViewModel
import com.squareup.moshi.Json

data class DTOBeer (
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "tagline") val tagline: String,
    @Json(name = "first_brewed") val firstBrewed: String,
    @Json(name = "description") val description: String,
    @Json(name = "image_url") val imageUrl: String
)
