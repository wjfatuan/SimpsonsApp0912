package com.example.simpsonsapp0912.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpsonsapp0912.services.Cat
import com.example.simpsonsapp0912.services.CatsApi
import kotlinx.coroutines.launch

class CatsViewModel : ViewModel() {

    var cat = MutableLiveData<Cat>()

    fun loadCats() {
        // cal the api using Retrofit
        viewModelScope.launch {
            val catsApi = CatsApi.getInstance()
            val cats = catsApi.search()
            cat.postValue(cats[0])
        }
    }
}