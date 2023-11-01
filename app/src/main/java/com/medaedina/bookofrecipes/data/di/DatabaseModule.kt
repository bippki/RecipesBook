package com.medaedina.bookofrecipes.data.di

import android.content.Context
import androidx.room.Room
import com.medaedina.bookofrecipes.data.local.db.MealsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        MealsDatabase::class.java,
        "meals_db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideYourDao(db: MealsDatabase) = db.getDao()
}