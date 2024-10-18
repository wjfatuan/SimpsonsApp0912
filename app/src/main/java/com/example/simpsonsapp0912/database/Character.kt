package com.example.simpsonsapp0912.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    val uid: Int,
    val name: String,
    val description: String,
    val image: String? = null
) {

}
