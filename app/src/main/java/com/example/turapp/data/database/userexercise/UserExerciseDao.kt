package com.example.turapp.data.database.userexercise

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserExerciseDao {
    @Query("SELECT * FROM user_exercise")
    fun getAllUserExercises(): Flow<List<UserExerciseTable>>

    @Query("SELECT * FROM user_exercise WHERE id = :id")
    fun getUserExerciseById(id: Int): Flow<UserExerciseTable?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExercise(userExerciseTable: UserExerciseTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExercises(userExerciseTables: List<UserExerciseTable>)

    @Update
    suspend fun updateUserExercise(userExerciseTable: UserExerciseTable)

    @Delete
    suspend fun deleteUserExercise(userExerciseTable: UserExerciseTable)
}