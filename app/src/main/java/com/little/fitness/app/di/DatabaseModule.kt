package com.little.fitness.app.di

import android.content.Context
import androidx.room.Room
import com.little.fitness.app.data.db.ExerciseDatabase
import com.little.fitness.app.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ExerciseDatabase::class.java,
            DATABASE_NAME

        ).build()

    @Singleton
    @Provides
    fun provideDao(database: ExerciseDatabase)= database.exerciseDao()

}