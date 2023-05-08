package com.example.turapp.data.database.user_program

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgramDao {
    @Query("SELECT * FROM user_program")
    fun getAllUserPrograms(): Flow<List<UserProgram>>

    @Query("SELECT * FROM user_program WHERE id = :userProgramId")
    fun getUserProgramById(userProgramId: Int): Flow<UserProgram?>

    @Query("SELECT * FROM user_program WHERE user_id = :userId")
    fun getUserProgramsByUserId(userId: Int): Flow<List<UserProgram>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgram(userProgram: UserProgram)

    @Update
    suspend fun updateUserProgram(userProgram: UserProgram)

    @Delete
    suspend fun deleteUserProgram(userProgram: UserProgram)
}