package com.little.fitness.app.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ExerciseDao {

    @Insert
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Query("SELECT * FROM exercise_table ORDER BY exercise_image ASC")
    fun getExercises(): Flow<List<ExerciseEntity>>

    @Query("SELECT * FROM exercise_table WHERE id = :id")
    fun getExercise(id: Int): Flow<ExerciseEntity>

    @Query("DELETE FROM exercise_table WHERE id = :id")
    suspend fun deleteExercises(id: Int)

}
