package com.medaedina.bookofrecipes.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.medaedina.bookofrecipes.data.local.dao.MealsDao
import com.medaedina.bookofrecipes.data.local.entity.MealEntity

@Database(
    entities = [MealEntity::class], // Tell the database the entries will hold data of this type
    version = 2
)

abstract class MealsDatabase : RoomDatabase() {

    abstract fun getDao(): MealsDao
}