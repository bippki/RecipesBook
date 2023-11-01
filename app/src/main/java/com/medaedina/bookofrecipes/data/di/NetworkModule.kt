package com.medaedina.bookofrecipes.data.di

import com.medaedina.bookofrecipes.data.remote.api.GenerateRecipeApi
import com.medaedina.bookofrecipes.data.remote.repository.GenerateRecipeRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiClientModule {
    @Provides
    @Named("generateRecipe")
    @Reusable
    internal fun provideGenerateRecipeRetrofitInstance(
        okHttpClient: OkHttpClient.Builder,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build()).build()
    }

    @Provides
    @Reusable
    internal fun provideGenerateRecipeApiClient(@Named("generateRecipe") retrofit: Retrofit): GenerateRecipeApi {
        return retrofit.create(GenerateRecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGenerateRecipeRepository(
        apiClient: GenerateRecipeApi
    ): GenerateRecipeRepository = GenerateRecipeRepository(generateRecipeApi = apiClient)

    @Provides
    @Reusable
    internal fun provideOkHttp(): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)
        return okHttpClient
    }



    companion object {
        private const val BASE_URL = "https://themealdb.com/api/json/v1/1/"
    }
}