package com.medaedina.bookofrecipes.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals_db")
data class MealEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "thumbPath") val thumbPath: String
)
