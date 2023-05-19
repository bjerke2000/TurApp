package com.example.turapp.data.database.user_program

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgramDao {
    @Query("SELECT * FROM user_program")
    fun getAllUserPrograms(): Flow<List<UserProgramTable>>

    @Query("SELECT * FROM user_program WHERE id = :userProgramId")
    fun getUserProgramById(userProgramId: Int): Flow<UserProgramTable?>

    @Query("SELECT * FROM user_program WHERE user_id = :userId")
    fun getUserProgramsByUserId(userId: Int): Flow<List<UserProgramTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgram(userProgramTable: UserProgramTable)

    @Update
    suspend fun updateUserProgram(userProgramTable: UserProgramTable)

    @Delete
    suspend fun deleteUserProgram(userProgramTable: UserProgramTable)
}