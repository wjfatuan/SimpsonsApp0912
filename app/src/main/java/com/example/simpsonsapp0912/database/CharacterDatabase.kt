package com.example.simpsonsapp0912.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}