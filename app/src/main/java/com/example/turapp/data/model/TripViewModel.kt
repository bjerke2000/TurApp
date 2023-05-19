package com.example.turapp.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turapp.data.api.TripApi
import com.example.turapp.data.api.tables.User
import com.example.turapp.data.database.TripRepository
import com.example.turapp.data.database.usertable.UserTable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TripViewModel @Inject constructor( private val tripRepository: TripRepository) : ViewModel() {
    private lateinit var currentUserApi : User
    private val currentUserDB = MutableLiveData<UserTable?>()
    val currentUser : LiveData<UserTable?> = currentUserDB

 fun addUser(phone: String){
     viewModelScope.launch {
         currentUserApi = withContext(Dispatchers.IO) {
             TripApi.retrofitService.getUserByPhone(phone)[0]

         }
        withContext(Dispatchers.IO) {
            tripRepository.insertUser(currentUserApi.ApiToDB(currentUserApi))
        }
     }
 }
    fun getUser(phone: String){
        viewModelScope.launch {
            currentUserDB.value = withContext(Dispatchers.IO) {
                tripRepository.getUser(phone)
            }
        }
    }

    fun doesUserExist(phone: String): Boolean{
        if ( tripRepository.doesUserExist(phone)) {
            return true
        } else {
            var tempUser: User? = null
            viewModelScope.launch {
                tempUser = withContext(Dispatchers.IO) {
                    TripApi.retrofitService.getUserByPhone(phone)[0]
                }
            }
            if (tempUser != null) {
                viewModelScope.launch {
                    withContext(Dispatchers.IO) {
                        tripRepository.insertUser(tempUser!!.ApiToDB(tempUser!!))
                    }
                }
                return true
            } else {
                return false
            }
        }
    }

}