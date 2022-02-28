package com.little.fitness.app.binding_adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.little.fitness.app.R

import com.little.fitness.app.util.Constants.Companion.CRUNCH_IMAGE
import com.little.fitness.app.util.Constants.Companion.DEADLIFT_IMAGE
import com.little.fitness.app.util.Constants.Companion.DUMBBELL_BICEPS_CURL_IMAGE
import com.little.fitness.app.util.Constants.Companion.PUSH_UP_IMAGE



class ExerciseImageBinding {

    companion object {

        @BindingAdapter("setImage")
        @JvmStatic
        fun setImage(imageView: ImageView, image: Int) {
            when (image) {
                PUSH_UP_IMAGE -> imageView.setImageResource(R.drawable.pushup_b)
                DUMBBELL_BICEPS_CURL_IMAGE -> imageView.setImageResource(R.drawable.dumbbell_b)
                DEADLIFT_IMAGE -> imageView.setImageResource(R.drawable.deadlift_b)
                CRUNCH_IMAGE -> imageView.setImageResource(R.drawable.crunch_b)
            }
        }

        @BindingAdapter("setMusclesImage")
        @JvmStatic
        fun setMusclesImage(imageView: ImageView, image: Int) {
            when (image) {
                PUSH_UP_IMAGE -> imageView.setImageResource(R.drawable.push_up_muscles)
                DUMBBELL_BICEPS_CURL_IMAGE -> imageView.setImageResource(R.drawable.biceps_muscles)
                DEADLIFT_IMAGE -> imageView.setImageResource(R.drawable.deadlift_muscles)
                CRUNCH_IMAGE -> imageView.setImageResource(R.drawable.crunch_muscles)
            }
        }
    }
}