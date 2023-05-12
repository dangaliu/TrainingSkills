package com.example.trainingskills.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.trainingskills.R
import com.example.trainingskills.databinding.FragmentSignInBinding
import com.example.trainingskills.models.LoginRequest
import com.example.trainingskills.ui.viewmodels.SignInViewModel
import com.example.trainingskills.utils.Resource
import com.example.trainingskills.utils.showDialog

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.btnLogin.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.signIn(LoginRequest(login, password))
        }
    }

    private fun setObservers() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
                }

                is Resource.Error -> {
                    showDialog("Error", it.message)
                }

                is Resource.Loading -> {}
            }
        }
    }
}