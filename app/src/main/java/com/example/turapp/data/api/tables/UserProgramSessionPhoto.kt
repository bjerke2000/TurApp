package com.example.turapp.data.api.tables

import com.squareup.moshi.Json

data class UserProgramSessionPhoto (
        @Json(name ="id") val id : Int = -1,
        @Json(name ="user_program_session_id") val userProgramSessionId: Int = -1,
        @Json(name = "photo_url") val photoUrl : String = "" //TODO legg inn standard photo URL
        )