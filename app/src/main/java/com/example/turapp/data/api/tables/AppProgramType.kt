package com.example.turapp.data.api.tables

import com.squareup.moshi.Json

data class AppProgramType (
    @Json(name="id") val id: Int =-1,
    @Json(name = "description") val description: String = "",
    @Json(name = "icon") val icon: String = "", //TODO sett inn default icon
    @Json(name = "back_color") val backColor: String = "" //TODO sett inn default bakgrunns farge
)