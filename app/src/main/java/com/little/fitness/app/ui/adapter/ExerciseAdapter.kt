package com.little.fitness.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.little.fitness.app.databinding.ExerciseItemBinding
import com.little.fitness.app.data.db.ExerciseEntity

class ExerciseAdapter constructor(
    private var onItemCLick: OnItemClick
) : RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    private var exercises = emptyList<ExerciseEntity>()

    inner class ViewHolder(private val binding: ExerciseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: ExerciseEntity) {
            binding.exerciseEntity = exercise

            binding.executePendingBindings()
        }

        init {
            itemView.setOnClickListener {
                onItemCLick.invoke(exercises[absoluteAdapterPosition].id)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ExerciseItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = exercises[position]
        holder.bind(currentMovie)
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    fun setData(newData: List<ExerciseEntity>) {
        exercises = newData
        notifyDataSetChanged()
    }

    interface OnItemClick {
        fun invoke(id: Int)
    }
}