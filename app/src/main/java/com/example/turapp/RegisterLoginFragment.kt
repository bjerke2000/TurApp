package com.example.turapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.turapp.databinding.FragmentRegisterLoginBinding


class RegisterLoginFragment : Fragment() {
    private var binding : FragmentRegisterLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentRegisterLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding?.lifecycleOwner = this

        return fragmentBinding.root
    }

}