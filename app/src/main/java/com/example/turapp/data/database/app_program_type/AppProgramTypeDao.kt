package com.example.turapp.data.database.app_program_type

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AppProgramTypeDao {
    @Query("SELECT * FROM app_program_type")
    fun getAllAppProgramTypes(): Flow<List<AppProgramTypeTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppProgramType(appProgramTypeTable: AppProgramTypeTable)

    @Delete
    suspend fun deleteAppProgramType(appProgramTypeTable: AppProgramTypeTable)

    @Update
    suspend fun updateAppProgramType(appProgramTypeTable: AppProgramTypeTable)
}