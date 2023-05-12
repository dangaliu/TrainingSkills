package com.example.trainingskills.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingskills.R
import com.example.trainingskills.databinding.FragmentMainBinding
import com.example.trainingskills.ui.adapters.TaskAdapter
import com.example.trainingskills.ui.viewmodels.MainViewModel
import com.example.trainingskills.utils.Resource
import com.example.trainingskills.utils.showDialog

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        viewModel.getTasks()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
    }

    private fun setListeners() {

    }

    private fun setObservers() {
        viewModel.tasks.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.rvTasks.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = TaskAdapter(it.data.data) {
                            findNavController().navigate(R.id.action_mainFragment_to_taskFragment)
                        }
                    }
                }

                is Resource.Error -> {
                    showDialog("Error", it.message)
                }

                is Resource.Loading -> {}
            }
        }
    }

}