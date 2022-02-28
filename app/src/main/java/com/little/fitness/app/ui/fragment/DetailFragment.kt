package com.little.fitness.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.little.fitness.app.R
import com.little.fitness.app.databinding.FragmentDetailBinding
import com.little.fitness.app.viewmodel.MainViewModel
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.fragment_detail.*


@FragmentScoped
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: MainViewModel

    private val beginner = "beginner"
    private val intermediate: String = "intermediate"
    private val expert: String = "expert"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)

        initFragment()

        return binding.root
    }

    private fun initFragment() {

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        loadExerciseFromDB(arguments?.getInt("id")!!)

        binding.ivPressBack.setOnClickListener(View.OnClickListener {
                        findNavController().popBackStack()
            })

    }



    private fun loadExerciseFromDB(id: Int) {

        viewModel.getExercise(id).observe(viewLifecycleOwner) {
            if (it != null) {
            }
            binding.exerciseEntity = it
            setDifficulty(it.difficulty)
            setEquipment(it.equipment)

        }
    }

    //set Difficulty Progress and Color
    private fun setDifficulty(difficulty: String) {

        when (difficulty) {
            beginner -> {

                binding.difficultyProgress.setProgressPercentage(25.0)
                binding.difficultyProgress.setProgressDrawableColor(ContextCompat.getColor(requireContext(), R.color.green))
                binding.tvDifficulty.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }
            intermediate -> {

                binding.difficultyProgress.setProgressPercentage(55.0)
                binding.difficultyProgress.setProgressDrawableColor(ContextCompat.getColor(requireContext(), R.color.orange))
                binding.tvDifficulty.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))

            }
            expert -> {

                binding.difficultyProgress.setProgressPercentage(85.0)
                binding.difficultyProgress.setProgressDrawableColor(ContextCompat.getColor(requireContext(), R.color.red))
                binding.tvDifficulty.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))

            }

        }

    }

    //setup Equipment Box for show the right equipment image
    private fun setEquipment(equipment: String) {

        when (equipment) {
            "no equipment" -> {
                llEquipment.visibility = View.GONE
            }
            "dumbbells" -> {
                llEquipment.visibility = View.VISIBLE
                ivEquipment.setImageResource(R.drawable.ic_dumbbells)

            }
            "barbell" -> {
                llEquipment.visibility = View.VISIBLE
                ivEquipment.setImageResource(R.drawable.ic_barbell)
            }

        }

    }

}

