package com.example.turapp.data.api.tables

import com.example.turapp.data.database.userexercise.UserExerciseTable
import com.squareup.moshi.Json

class UserExercise (
    @Json(name = "id") val id : Int = -1,
    @Json(name = "user_id") val userId: Int =-1,
    @Json(name = "name") val name : String = "undefined",
    @Json(name = "photo_url") val photoUrl: String = "", //TODO legg inn standard photo url
    @Json(name = "description") val description: String = "",
    @Json(name = "icon") val icon: String = "", //TODO legg inn standard icon
    @Json(name = "infobox_color") val infoboxColor: String = "" //TODO legg inn standard infobox farge
    ){
    fun ApiToDB(userProgramExercise: UserProgramExercise): UserExerciseTable {
        return UserExerciseTable(
            liveID = id,
            userProgramId = userProgramExercise.userProgramId,
            userId = userId,
            name = name,
            photoUrl = photoUrl,
            description = description,
            icon = icon,
            infoboxColor = infoboxColor,
            mtmId = userProgramExercise.id
        )
    }
}
