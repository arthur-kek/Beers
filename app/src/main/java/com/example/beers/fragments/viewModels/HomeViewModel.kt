package com.example.beers.fragments.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beers.BeersApi
import com.example.beers.entities.DSBeer
import com.example.beers.entities.DTOBeer
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

enum class BeerPhotoStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<BeerPhotoStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<BeerPhotoStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private var _beers = MutableLiveData<List<DSBeer?>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val beers: MutableLiveData<List<DSBeer?>> = _beers

    fun requestBeers(): List<DSBeer?>? {
        runBlocking {
            _status.value = BeerPhotoStatus.LOADING
            try {
                _beers.value = BeersApi.retrofitService.getBeers().map { dto ->
                    DSBeer(
                        dto.id,
                        dto.name,
                        dto.tagline,
                        dto.firstBrewed,
                        dto.description,
                        dto.imageUrl
                    )
                }
                _status.value = BeerPhotoStatus.DONE
            } catch (e: Exception) {
                _status.value = BeerPhotoStatus.ERROR
                _beers.value = listOf()
            }
        }

        return beers.value
    }
}