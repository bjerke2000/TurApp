package com.example.turapp.data.database.userexercise

import androidx.room.*
import com.example.turapp.data.database.user_program.UserProgram

@Entity(
    tableName = "user_exercise",
    foreignKeys = [
        ForeignKey(
            entity = UserProgram::class,
            parentColumns = ["id"],
            childColumns = ["user_program_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["user_program_id"])
    ]
)
data class UserExercise (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "user_program_id") val userProgramId : Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo_url") val photoUrl: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "infobox_color") val infoboxColor: String
)