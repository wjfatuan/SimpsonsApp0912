package com.example.simpsonsapp0912.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.simpsonsapp0912.database.Character
import com.example.simpsonsapp0912.database.CharacterDatabase
import kotlinx.coroutines.launch
import java.io.PrintStream

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val simpsonsCharacters = arrayListOf<String>()
    var selectedCharacter: MutableLiveData<String> = MutableLiveData()

    fun selectCharacter(i:Int) {
        selectedCharacter.postValue(simpsonsCharacters[i])
    }

    fun addCharacter(name: String) {
        simpsonsCharacters.add(name)
        writeCharacters()
        saveCharacter(Character(simpsonsCharacters.size, name, name))
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

    fun saveCharacter(c: Character) {
        viewModelScope.launch {
            val db = CharacterDatabase.getDatabase(getApplication())
            db.characterDao().save(c)
        }
    }

    fun loadCharacters() {
        viewModelScope.launch {
            val db = CharacterDatabase.getDatabase(getApplication())
            val characters = db.characterDao().getAll()
            if(characters.isEmpty()) {
                addCharacter("bart")
            }
            Log.d("DBROOM", "Characters: $characters")
            simpsonsCharacters.clear()
            for (c in characters) {
                simpsonsCharacters.add(c.name)
            }

        }
    }

}