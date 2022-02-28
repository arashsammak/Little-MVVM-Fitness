package com.little.fitness.app.data

import com.little.fitness.app.data.db.ExerciseEntity
import com.little.fitness.app.util.Constants

object ExerciseOfflineData {

    val exercises: Array<ExerciseEntity>  = arrayOf(

        ExerciseEntity(
            "Push up",
            Constants.PUSH_UP_IMAGE,
            "intermediate", "no equipment", "chest", "triceps"
        ),
        ExerciseEntity(
            "Biceps Curl",
            Constants.DUMBBELL_BICEPS_CURL_IMAGE,
            "intermediate", "dumbbells", "biceps", "none"
        ),
        ExerciseEntity(
            "Deadlift",
            Constants.DEADLIFT_IMAGE,
            "expert", "barbell", "glutes", "hamstrings and lower back"
        ),
        ExerciseEntity(
            "Crunch",
            Constants.CRUNCH_IMAGE,
            "beginner", "no equipment", "abs", "none"
        )

    )

}