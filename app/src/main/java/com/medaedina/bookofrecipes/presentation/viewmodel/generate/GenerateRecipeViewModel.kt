package com.medaedina.bookofrecipes.presentation.viewmodel.generate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medaedina.bookofrecipes.data.remote.model.Meal
import com.medaedina.bookofrecipes.data.remote.repository.GenerateRecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenerateRecipeViewModel @Inject constructor(private val generateRecipeRepository: GenerateRecipeRepository) :
    ViewModel() {

    private val _mealLiveData: MutableLiveData<Meal?> = MutableLiveData()
    val mealLiveData: LiveData<Meal?> = _mealLiveData

    suspend fun generateRecipe(name: String) {
        val response = generateRecipeRepository.generateRecipe(name = name)
        if (response.meals == null || response.meals.isEmpty()) {
            _mealLiveData.postValue(null)
        } else {
            _mealLiveData.postValue(response.meals[0])
        }
    }
}