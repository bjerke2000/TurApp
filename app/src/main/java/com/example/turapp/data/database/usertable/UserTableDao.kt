package com.example.turapp.data.database.usertable

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserTableDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userTable: UserTable)

    @Delete
    suspend fun delete(userTable: UserTable)

    @Query("Select * FROM user WHERE phone = :phoneNumber")
    fun getUser(phoneNumber: String): UserTable?

    @Update
    suspend fun updateUser(userTable:UserTable)
}