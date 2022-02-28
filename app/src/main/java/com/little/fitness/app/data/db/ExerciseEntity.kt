package com.little.fitness.app.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.little.fitness.app.util.Constants.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ExerciseEntity(

    @ColumnInfo(name = "EXERCISE_NAME")
    val name: String,

    @ColumnInfo(name = "EXERCISE_IMAGE")
    val image: Int,

    @ColumnInfo(name = "EXERCISE_DIFFICULTY")
    val difficulty: String,

    @ColumnInfo(name = "EXERCISE_EQUIPMENT")
    val equipment: String,

    @ColumnInfo(name = "EXERCISE_PRIMARY_MUSCLES")
    val primaryMuscles: String,

    @ColumnInfo(name = "EXERCISE_SECONDARY_MUSCLES")
    val secondaryMuscles: String,




    ) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}