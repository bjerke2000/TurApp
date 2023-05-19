package com.example.turapp.data.database.userexercise

import androidx.room.*
import com.example.turapp.data.api.tables.UserExercise
import com.example.turapp.data.api.tables.UserProgramExercise
import com.example.turapp.data.database.user_program.UserProgramTable

@Entity(
    tableName = "user_exercise",
    foreignKeys = [
        ForeignKey(
            entity = UserProgramTable::class,
            parentColumns = ["id"],
            childColumns = ["user_program_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["user_program_id"])
    ]
)
data class UserExerciseTable (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "live_id") val liveID: Int,
    @ColumnInfo(name = "user_program_id") val userProgramId : Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo_url") val photoUrl: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "infobox_color") val infoboxColor: String,
    @ColumnInfo(name = "mtm_id") val mtmId: Int
){
    fun DBToApi(): UserExercise {
        return UserExercise(
            id = liveID,
            userId = userId,
            name = name,
            photoUrl = photoUrl,
            description = description,
            icon = icon,
            infoboxColor = infoboxColor
        )
    }
    fun GetMTMRelation(): UserProgramExercise {
        return UserProgramExercise(
            id = mtmId,
            userExerciseId = liveID,
            userProgramId = userProgramId
        )
    }
}