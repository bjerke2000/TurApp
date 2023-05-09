package com.example.turapp.data.database

import com.example.turapp.data.database.app_program_type.AppProgramTypeDao
import com.example.turapp.data.database.user_program.UserProgramDao
import com.example.turapp.data.database.user_program_session.UserProgramSessionDao
import com.example.turapp.data.database.userexercise.UserExerciseDao
import com.example.turapp.data.database.usertable.UserTable
import com.example.turapp.data.database.usertable.UserTableDao
import javax.inject.Inject

class TripRepository @Inject constructor(
    private val appProgramTypeDao: AppProgramTypeDao,
    private val userProgramDao: UserProgramDao,
    private val userProgramSessionDao: UserProgramSessionDao,
    private val userExerciseDao: UserExerciseDao,
    private val userTableDao: UserTableDao
    ) {

    fun getUser(phoneNumber: String): UserTable? {
        return userTableDao.getUser(phoneNumber)
    }

    suspend fun insert(userTable: UserTable) {
        userTableDao.insert(userTable)
    }

    suspend fun delete(userTable: UserTable) {
        userTableDao.delete(userTable)
    }

    suspend fun update(userTable: UserTable) {
        userTableDao.updateUser(userTable)
    }

    fun doesUserExist(phoneNumber: String): Boolean{
        return getUser(phoneNumber) != null
    }

}