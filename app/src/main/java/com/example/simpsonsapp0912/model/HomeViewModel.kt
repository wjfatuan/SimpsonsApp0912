package com.example.simpsonsapp0912.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.simpsonsapp0912.database.CharacterDatabase
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintStream
import java.util.Scanner

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val simpsonsCharacters = arrayListOf("Marge", "Lisa", "Homer")
    var selectedCharacter: MutableLiveData<String> = MutableLiveData()

    fun selectCharacter(i:Int) {
        selectedCharacter.postValue(simpsonsCharacters[i])
    }

    fun addCharacter(name: String) {
        simpsonsCharacters.add(name)
        writeCharacters()
    }

    fun removeCharacter(name: String) {
        simpsonsCharacters.remove(name)
    }

    fun writeCharacters() {
        Log.d("STORAGE","Writing characters in ${getApplication<Application>().filesDir.absolutePath}")
        val out = PrintStream(getApplication<Application>().openFileOutput("characters.txt", Context.MODE_PRIVATE))
        out.println(simpsonsCharacters)
        out.close()
    }

    fun loadCharacters() {
        viewModelScope.launch {
            val db = Room.databaseBuilder(
                getApplication<Application>().applicationContext,
                CharacterDatabase::class.java, "simpsons.db"
            ).build()
            val characters = db.characterDao().getAll()
            Log.d("DBROOM", "Characters: $characters")
        }

    }

}