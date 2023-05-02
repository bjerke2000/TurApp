package com.example.turapp.data.database.usertable

import kotlinx.coroutines.flow.Flow

class UserTableRepository(private val userTableDao: UserTableDao) {
    fun getUser(phoneNumber: String): Flow<UserTable> {
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
}