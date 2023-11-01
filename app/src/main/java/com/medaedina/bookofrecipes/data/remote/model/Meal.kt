package com.medaedina.bookofrecipes.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//аргумент между экранами
@Parcelize
data class Meal(
    val idMeal: String,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String
) : Parcelable