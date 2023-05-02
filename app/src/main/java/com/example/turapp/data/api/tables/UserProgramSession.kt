package com.example.turapp.data.api.tables

import com.squareup.moshi.Json
import java.util.Date

data class UserProgramSession (
    @Json(name = "id") val id : Int = -1,
    @Json(name = "user_program_id") val userProgramId : Int = -1,
    @Json(name = "description") val description: String = "",
    @Json(name = "startTime") val startTime: String = "0000-00-00 00:00:00", //YYYY-mm-dd HH:mm:ss
    @Json(name = "time_spent") val timeSpent: Int = -1 //Ant sekunder
)