package com.example.turapp.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turapp.data.api.TripApi
import com.example.turapp.data.api.tables.User
import com.example.turapp.data.api.tables.UserExercise
import com.example.turapp.data.api.tables.UserProgramExercise
import com.example.turapp.data.database.TripRepository
import com.example.turapp.data.database.userexercise.UserExerciseTable
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
    private val _allUsers = MutableLiveData<List<UserTable>>()

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

    suspend fun doesUserExist(phone: String): Boolean {
        return withContext(Dispatchers.IO) {
            if (tripRepository.doesUserExist(phone)) {
                true
            } else {
                val tempUser = TripApi.retrofitService.getUserByPhone(phone).firstOrNull()
                if (tempUser != null) {
                    tripRepository.insertUser(tempUser.ApiToDB(tempUser))
                    true
                } else {
                    false
                }
            }
        }
    }

    fun alreadyLoggedIn(): Boolean{
        var returnVal : Boolean = false
       viewModelScope.launch { if (withContext(Dispatchers.IO) {tripRepository.getUserCount()}==1 ) {
            currentUserDB.value = withContext(Dispatchers.IO) { tripRepository.getFirstUser()}
             returnVal = true
        }

    }
        return returnVal
    }

    fun getUserProgramExercises(programId: Int): List<UserExerciseTable> {
        var relations = listOf<UserProgramExercise>()
        viewModelScope.launch { relations = withContext(Dispatchers.IO) {  TripApi.retrofitService.getUserProgramExercisesByProgramID(programId) }}
        val exerciseList = mutableListOf<UserExerciseTable>()
        viewModelScope.launch {
            for (relation in relations) {
            exerciseList.add( withContext(Dispatchers.IO) {TripApi.retrofitService.getUserExercise(relation.userExerciseId).ApiToDB(relation)} )
        }}
        return exerciseList
    }

}