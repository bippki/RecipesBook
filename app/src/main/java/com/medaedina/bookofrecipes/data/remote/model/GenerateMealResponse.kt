package com.medaedina.bookofrecipes.data.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class GenerateMealResponse(
    @SerializedName("meals") val meals: List<Meal>
)