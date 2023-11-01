package com.medaedina.bookofrecipes.data.remote.api

import com.medaedina.bookofrecipes.data.remote.model.GenerateMealResponse
import com.medaedina.bookofrecipes.data.remote.model.Meal
import retrofit2.http.GET
import retrofit2.http.Query

interface GenerateRecipeApi {
    @GET("search.php")
    suspend fun generateRecipe(@Query("s") name: String): GenerateMealResponse
}