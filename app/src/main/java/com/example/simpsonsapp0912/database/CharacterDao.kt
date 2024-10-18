package com.example.simpsonsapp0912.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {
    //CRUD
    @Insert
    suspend fun save(c: Character)
    @Delete
    suspend fun delete(c: Character)
    @Query("SELECT * FROM characters")
    suspend fun getAll(): List<Character>
    @Query("SELECT * FROM characters WHERE uid = :id")
    suspend fun getById(id: Int): Character
    @Query("SELECT * FROM characters WHERE name = :n")
    suspend fun getByName(n: String): Character

}