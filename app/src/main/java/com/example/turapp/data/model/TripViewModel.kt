package com.example.turapp.data.model

import androidx.lifecycle.ViewModel
import com.example.turapp.data.database.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TripViewModel @Inject constructor( tripRepository: TripRepository) : ViewModel() {



}