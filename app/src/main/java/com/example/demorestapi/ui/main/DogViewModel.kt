package com.example.demorestapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demorestapi.network.Dog
import com.example.demorestapi.network.DogApi
import kotlinx.coroutines.launch

enum class DogApiStatus { LOADING, ERROR, DONE }

class DogViewModel : ViewModel() {
    private val _status = MutableLiveData<DogApiStatus>()
    val status: LiveData<DogApiStatus> = _status

    private val _dogs = MutableLiveData<List<Dog>>()
    val dogs: LiveData<List<Dog>> = _dogs

    private val _dog = MutableLiveData<Dog>()
    val dog: LiveData<Dog> = _dog

    init {
        getDogList()
    }

    fun getDogList() {
        viewModelScope.launch {
            _status.value = DogApiStatus.LOADING
            try {
                _dogs.value = DogApi.retrofitService.getDogs()
                _status.value = DogApiStatus.DONE
            } catch (e: Exception) {
                _status.value = DogApiStatus.ERROR
                _dogs.value = listOf()
            }
        }
    }

    fun onDogClicked(dog: Dog) {
        _dog.value = dog
    }
}