package com.example.simpsonsapp0912.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Character::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object {
        const val DATABASE_NAME = "simpsons.db"
        fun getDatabase(ctx: Context): CharacterDatabase {
            val db = Room.databaseBuilder(
                ctx, CharacterDatabase::class.java, DATABASE_NAME
            ).build()
            return db
        }
    }

}