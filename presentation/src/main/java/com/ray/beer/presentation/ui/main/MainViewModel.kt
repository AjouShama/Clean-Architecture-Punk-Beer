package com.ray.beer.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.usecase.beer.GetRandomPunkBeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomPunkBeerUseCase: GetRandomPunkBeerUseCase
) : ViewModel() {

    private val _punkBeer = MutableLiveData<PunkBeerPure>()
    val punkBeer: LiveData<PunkBeerPure>
        get() = _punkBeer

    init {
        getRandomPunkBeer()
    }

    fun onRetryClick() {
        getRandomPunkBeer()
    }

    private fun getRandomPunkBeer() {
        viewModelScope.launch {
            getRandomPunkBeerUseCase.invoke().collect {
                if (it.isSuccess) {
                    _punkBeer.value = it.data ?: PunkBeerPure.default
                }
            }
        }
    }
}