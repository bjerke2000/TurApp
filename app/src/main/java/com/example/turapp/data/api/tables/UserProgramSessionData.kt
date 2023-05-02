package com.example.turapp.data.api.tables

import com.squareup.moshi.Json

data class UserProgramSessionData (
    @Json(name ="id") val id : Int = -1,
    @Json(name = "user_program_session_id") val userProgramSessionId: Int =-1,
    @Json(name = "floatData1") val horizontalSpeed : Double = 0.0,
    @Json(name = "floatData2") val verticalSpeed : Double = 0.0,
    @Json(name = "floatData3") val floatData3 : Double = 0.0,
    @Json(name = "stringData1") val stringData1 : String = ""
    )