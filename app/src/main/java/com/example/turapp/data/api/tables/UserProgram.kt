package com.example.turapp.data.api.tables

import com.squareup.moshi.Json

data class UserProgram (
    @Json(name = "id") val id: Int = -1,
    @Json(name = "user_id") val userId: Int = -1,
    @Json(name = "app_program_type") val appProgramTypeId: Int = -1,
    @Json(name = "name") val name: String = "undefined",
    @Json(name = "description") val description: String = "",
    @Json(name = "use_timing") val useTiming: Int = 0,
    @Json(name = "icon") val icon: String = "" //TODO sett in default icon
    )