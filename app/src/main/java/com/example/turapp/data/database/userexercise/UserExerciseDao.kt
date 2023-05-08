package com.example.turapp.data.database.userexercise

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserExerciseDao {
    @Query("SELECT * FROM user_exercise")
    fun getAllUserExercises(): Flow<List<UserExercise>>

    @Query("SELECT * FROM user_exercise WHERE id = :id")
    fun getUserExerciseById(id: Int): Flow<UserExercise?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExercise(userExercise: UserExercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExercises(userExercises: List<UserExercise>)

    @Update
    suspend fun updateUserExercise(userExercise: UserExercise)

    @Delete
    suspend fun deleteUserExercise(userExercise: UserExercise)
}