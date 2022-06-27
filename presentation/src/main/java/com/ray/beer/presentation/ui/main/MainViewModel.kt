package com.ray.beer.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ray.beer.domain.model.beer.PunkBeerPure
import com.ray.beer.domain.usecase.beer.GetRandomPunkBeerUseCase
import com.ray.beer.domain.usecase.beer.GetSpecificPunkBeerUseCase
import com.ray.beer.presentation.ui.common.util.valueOrDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomPunkBeerUseCase: GetRandomPunkBeerUseCase,
    private val getSpecificPunkBeerUseCase: GetSpecificPunkBeerUseCase
) : ViewModel() {

    private val _punkBeer = MutableLiveData<PunkBeerPure>()
    val punkBeer: LiveData<PunkBeerPure>
        get() = _punkBeer

    val punkBeerName: MutableLiveData<String> = MutableLiveData()

    fun onRandomPunkBeerClick() {
        viewModelScope.launch {
            getRandomPunkBeerUseCase().collect {
                if (it.isSuccess) {
                    _punkBeer.value = it.data ?: PunkBeerPure.default
                }
            }
        }
    }

    fun onSpecificPunkBeerClick() {
        viewModelScope.launch {
            getSpecificPunkBeerUseCase(punkBeerName.valueOrDefault).collect {
                if (it.isSuccess) {
                    _punkBeer.value = it.data ?: PunkBeerPure.default
                }
            }
        }
    }
}