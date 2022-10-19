package com.example.beers

import com.example.beers.entities.DTOBeer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.punkapi.com/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BeerServices {

    @GET("beers")
    suspend fun getBeers(): List<DTOBeer>

}

object BeersApi {
    val retrofitService: BeerServices by lazy { retrofit.create(BeerServices::class.java) }
}