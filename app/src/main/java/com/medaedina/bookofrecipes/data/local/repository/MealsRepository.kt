package com.medaedina.bookofrecipes.data.local.repository

import com.medaedina.bookofrecipes.data.local.dao.MealsDao
import com.medaedina.bookofrecipes.data.local.entity.MealEntity
import com.medaedina.bookofrecipes.data.remote.model.Meal
import javax.inject.Inject

class MealsRepository @Inject constructor(private val mealsDao: MealsDao) {
    suspend fun getMeals(): List<Meal> {
        val list = mealsDao.getAll()
        val result = mutableListOf<Meal>()
        list.forEach {
            result.add(
                Meal(
                    idMeal = it.id,
                    strMealThumb = it.thumbPath,
                    strMeal = it.title,
                    strInstructions = it.instructions
                )
            )
        }
        return result
    }

    suspend fun saveMeal(meal: MealEntity) = mealsDao.saveMeal(meal = meal)
}