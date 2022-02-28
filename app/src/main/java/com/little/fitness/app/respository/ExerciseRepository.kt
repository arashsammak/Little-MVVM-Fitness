package com.little.fitness.app.respository

import com.little.fitness.app.data.db.ExerciseEntity
import com.little.fitness.app.data.db.ExerciseDao
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class ExerciseRepository @Inject constructor(
    exerciseDap: ExerciseDao,

    ) {

    private val local = exerciseDap

    fun getExercises(): Flow<List<ExerciseEntity>> {
        return local.getExercises();
    }

    fun getExercise(id: Int): Flow<ExerciseEntity> {
        return local.getExercise(id);
    }

    suspend fun insertExercise(exerciseEntity: ExerciseEntity) {

        local.insertExercise(exerciseEntity)
    }

}