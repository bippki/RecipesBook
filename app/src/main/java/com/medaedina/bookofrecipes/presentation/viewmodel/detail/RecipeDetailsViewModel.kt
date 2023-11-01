package com.medaedina.bookofrecipes.presentation.viewmodel.detail

import androidx.lifecycle.ViewModel
import com.medaedina.bookofrecipes.data.local.entity.MealEntity
import com.medaedina.bookofrecipes.data.local.repository.MealsRepository
import com.medaedina.bookofrecipes.data.remote.model.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    //ассинхронно
    suspend fun saveMeal(meal: Meal) {
        val mealEntity = MealEntity(
            id = meal.idMeal,
            title = meal.strMeal,
            instructions = meal.strInstructions,
            thumbPath = meal.strMealThumb
        )
        mealsRepository.saveMeal(mealEntity)
    }
}