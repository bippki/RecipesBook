package com.medaedina.bookofrecipes.presentation.viewmodel.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medaedina.bookofrecipes.data.local.entity.MealEntity
import com.medaedina.bookofrecipes.data.local.repository.MealsRepository
import com.medaedina.bookofrecipes.data.remote.model.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(private val mealsRepository: MealsRepository) :
    ViewModel() {
    //коллбеки
    fun getMeals(onSuccess: (List<Meal>) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val meals = mealsRepository.getMeals()
                withContext(Dispatchers.Main) {
                    onSuccess(meals)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e.message ?: "Error occurred while getting meals")
                }
            }
        }

    }
}