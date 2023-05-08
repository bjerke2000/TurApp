package com.example.turapp.data.database.user_program_session

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgramSessionDao {
    @Query("SELECT * FROM user_program_session")
    fun getAllUserProgramSessions(): Flow<List<UserProgramSession>>

    @Query("SELECT * FROM user_program_session WHERE id = :userProgramSessionId")
    fun getUserProgramSessionById(userProgramSessionId: Int): Flow<UserProgramSession?>

    @Query("SELECT * FROM user_program_session WHERE user_program_id = :userProgramId")
    fun getUserProgramSessionsByUserProgramId(userProgramId: Int): Flow<List<UserProgramSession>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgramSession(userProgramSession: UserProgramSession)

    @Update
    suspend fun updateUserProgramSession(userProgramSession: UserProgramSession)

    @Delete
    suspend fun deleteUserProgramSession(userProgramSession: UserProgramSession)
}