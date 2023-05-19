package com.example.turapp.data.database.user_program_session

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgramSessionDao {
    @Query("SELECT * FROM user_program_session")
    fun getAllUserProgramSessions(): Flow<List<UserProgramSessionTable>>

    @Query("SELECT * FROM user_program_session WHERE id = :userProgramSessionId")
    fun getUserProgramSessionById(userProgramSessionId: Int): Flow<UserProgramSessionTable?>

    @Query("SELECT * FROM user_program_session WHERE user_program_id = :userProgramId")
    fun getUserProgramSessionsByUserProgramId(userProgramId: Int): Flow<List<UserProgramSessionTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgramSession(userProgramSessionTable: UserProgramSessionTable)

    @Update
    suspend fun updateUserProgramSession(userProgramSessionTable: UserProgramSessionTable)

    @Delete
    suspend fun deleteUserProgramSession(userProgramSessionTable: UserProgramSessionTable)
}