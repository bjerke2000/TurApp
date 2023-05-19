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

    @Query("SELECT COUNT(*) FROM user")
    fun getUserCount(): Int

    @Query("SELECT * FROM user LIMIT 1")
    fun getFirstUser(): UserTable?

    @Update
    suspend fun updateUser(userTable:UserTable)
}