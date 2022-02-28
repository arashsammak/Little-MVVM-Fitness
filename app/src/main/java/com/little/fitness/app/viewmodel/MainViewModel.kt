package com.little.fitness.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.little.fitness.app.data.db.ExerciseEntity
import com.little.fitness.app.respository.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ExerciseRepository,
    application: Application

) : AndroidViewModel(application) {

    fun getExercises(): LiveData<List<ExerciseEntity>> = repository.getExercises().asLiveData()
    fun getExercise(id: Int): LiveData<ExerciseEntity> = repository.getExercise(id).asLiveData()

    fun insertExercise(exerciseEntity: ExerciseEntity) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insertExercise(exerciseEntity)
        }
    }
}









