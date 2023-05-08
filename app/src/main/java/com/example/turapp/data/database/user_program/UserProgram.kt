package com.example.turapp.data.database.user_program

import androidx.room.*
import com.example.turapp.data.database.app_program_type.AppProgramType

@Entity(tableName = "user_program",
    foreignKeys = [
        ForeignKey(
            entity = AppProgramType::class,
            parentColumns = ["id"],
            childColumns = ["app_program_type_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["app_program_type_id"])
    ]
)
data class UserProgram (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "app_program_type_id") val appProgramTypeId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "use_timing") val useTiming: Int,
    @ColumnInfo(name = "icon") val icon: String
)