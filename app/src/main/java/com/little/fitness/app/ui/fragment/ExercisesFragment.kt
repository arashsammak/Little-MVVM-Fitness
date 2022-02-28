package com.little.fitness.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.little.fitness.app.R
import com.little.fitness.app.data.ExerciseOfflineData
import com.little.fitness.app.databinding.FragmentExerciseListBinding
import com.little.fitness.app.ui.adapter.ExerciseAdapter
import com.little.fitness.app.util.PreferenceHelper
import com.little.fitness.app.util.PreferenceHelper.get
import com.little.fitness.app.util.PreferenceHelper.set
import com.little.fitness.app.viewmodel.MainViewModel
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.scopes.FragmentScoped


@FragmentScoped
class ExercisesFragment : Fragment(), ExerciseAdapter.OnItemClick {

    private lateinit var binding: FragmentExerciseListBinding
    lateinit var viewModel: MainViewModel
    private val adapter by lazy { ExerciseAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExerciseListBinding.inflate(inflater, container, false)


        initFragment()


        return binding.root
    }

    private fun initFragment() {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)



        binding.rvExercises.layoutManager = LinearLayoutManager(context)
        binding.rvExercises.adapter = adapter


        generateDatabaseData()

        viewModel.getExercises().observe(viewLifecycleOwner, { response ->

            response.let { adapter.setData(it) }

        })
    }

    override fun invoke(id: Int) {

        val bundle = bundleOf( "id" to id)



        findNavController().navigate(R.id.detailFragment,bundle)

    }

    private fun generateDatabaseData() {

        if (PreferenceHelper.defaultPrefs(requireContext())["FIRST", ""] == "") {

            for (exercise in ExerciseOfflineData.exercises){
                viewModel.insertExercise(exercise)
            }
        }
        PreferenceHelper.defaultPrefs(requireContext())["FIRST"] = "FILLED"
    }

}