package com.medaedina.bookofrecipes.data.remote.repository

import com.medaedina.bookofrecipes.data.remote.api.GenerateRecipeApi
import com.medaedina.bookofrecipes.data.remote.model.GenerateMealResponse
import com.medaedina.bookofrecipes.data.remote.model.Meal
import javax.inject.Inject

class GenerateRecipeRepository @Inject constructor(private val generateRecipeApi: GenerateRecipeApi) {
    suspend fun generateRecipe(name: String): GenerateMealResponse {
        return generateRecipeApi.generateRecipe(name = name)
    }
}