package com.example.turapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.turapp.data.model.TripViewModel
import com.example.turapp.databinding.FragmentRegisterLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterLoginFragment : Fragment() {
    private var binding : FragmentRegisterLoginBinding? = null
    private val viewModel: TripViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (viewModel.alreadyLoggedIn()) {
            findNavController().navigate(R.id.action_registerLoginFragment_to_homeFragment)
        }
        val fragmentBinding = FragmentRegisterLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding?.lifecycleOwner = this
        viewModel.currentUser.observe(viewLifecycleOwner) {value ->
            binding?.tempText!!.text = value?.name
        }
        binding?.registerLoginFragment = this
        return fragmentBinding.root
    }

    fun loginUser(){
        val phoneNumber = binding?.phoneNumber?.text.toString()
        lifecycleScope.launch {
        if (viewModel.doesUserExist(phoneNumber)) {
            viewModel.getUser(phoneNumber)
            findNavController().navigate(R.id.action_registerLoginFragment_to_homeFragment)
        } else {
            binding?.phoneNumber?.error = "User does not exist"
        }
    }}

}