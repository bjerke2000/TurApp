package com.example.turapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.turapp.data.api.TripApi
import com.example.turapp.data.api.tables.User
import com.example.turapp.data.model.TripViewModel
import com.example.turapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        lifecycleScope.launch {
            user = withContext(Dispatchers.IO) {
                TripApi.retrofitService.getUserByPhone("99966633")[0]
            }

            binding?.defaultText!!.text = user.name.toString()
        }
        return fragmentBinding.root
    }

}