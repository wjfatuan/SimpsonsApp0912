package com.example.simpsonsapp0912.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterDetailViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData("Bart")
    val description: MutableLiveData<String> = MutableLiveData("Marge is Homer's wife, and has a daughter named Lisa and a son Bart. Also, she has blue hair and green eyes.")


}