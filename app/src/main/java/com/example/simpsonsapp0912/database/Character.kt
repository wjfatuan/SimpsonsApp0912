package com.example.simpsonsapp0912.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import java.util.Date

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    val uid: Int,
    val name: String,
    val description: String,
    val image: String? = null
) {

}

@Dao
interface CharacterDao {
    //CRUD
    @Insert
    fun save(c: Character)
    @Delete
    fun delete(c: Character)
    @Query("SELECT * FROM characters")
    fun getAll(): List<Character>
    @Query("SELECT * FROM characters WHERE uid = :id")
    fun getById(id: Int): Character
    @Query("SELECT * FROM characters WHERE name = :n")
    fun getByName(n: String): Character

}

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}