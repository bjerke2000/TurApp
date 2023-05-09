package com.example.turapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.turapp.data.api.tables.User
import com.example.turapp.data.model.TripViewModel
import com.example.turapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private lateinit var user: User
    private val viewModel: TripViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        binding?.lifecycleOwner = this
        viewModel.addUser("99966633")
        viewModel.getUser("99966633")
        viewModel.currentUser.observe(viewLifecycleOwner) {value ->
            binding?.defaultText!!.text = value?.name
        }
        return fragmentBinding.root
    }

}