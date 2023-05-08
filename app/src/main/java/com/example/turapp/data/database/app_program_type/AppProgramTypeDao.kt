package com.example.turapp.data.database.app_program_type

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AppProgramTypeDao {
    @Query("SELECT * FROM app_program_type")
    fun getAllAppProgramTypes(): Flow<List<AppProgramType>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppProgramType(appProgramType: AppProgramType)

    @Delete
    suspend fun deleteAppProgramType(appProgramType: AppProgramType)

    @Update
    suspend fun updateAppProgramType(appProgramType: AppProgramType)
}