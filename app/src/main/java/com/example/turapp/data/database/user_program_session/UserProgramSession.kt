package com.example.turapp.data.database.user_program_session

import androidx.room.*
import androidx.room.ForeignKey.Companion.CASCADE
import com.example.turapp.data.database.user_program.UserProgram

@Entity(
    tableName = "user_program_session",
    foreignKeys = [
        ForeignKey(
            entity = UserProgram::class,
            parentColumns = ["id"],
            childColumns = ["user_program_id"],
            onDelete = CASCADE
        )
    ],
    indices = [
        Index(value = ["user_program_id"])
    ]
)
data class UserProgramSession (
    @PrimaryKey @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "user_program_session_id") val userProgramSessionId: Int,
    @ColumnInfo(name = "user_program_id") val userProgramId : Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "start_time") val startTime: String,
    @ColumnInfo(name = "time_spent") val timeSpent: Int,
    @ColumnInfo(name = "horizontal_speed") val horizontalSpeed : Double,
    @ColumnInfo(name = "vertical_speed") val verticalSpeed : Double,
    @ColumnInfo(name = "float_data_3") val floatData3 : Double,
    @ColumnInfo(name = "string_data_1") val stringData1 : String,
    @ColumnInfo(name = "photo_url") val photoUrl : String
)