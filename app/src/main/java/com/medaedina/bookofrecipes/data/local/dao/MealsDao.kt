package com.medaedina.bookofrecipes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.medaedina.bookofrecipes.data.local.entity.MealEntity

@Dao
interface MealsDao {
    @Query("SELECT * FROM meals_db")
    fun getAll(): List<MealEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMeal(meal: MealEntity)
}