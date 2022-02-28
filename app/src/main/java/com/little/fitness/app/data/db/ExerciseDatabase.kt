package com.little.fitness.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExerciseEntity::class], version = 1)


abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
}