package com.example.turapp.data.api.tables

import com.example.turapp.data.database.usertable.UserTable
import com.squareup.moshi.Json

class User (
    @Json(name = "id") val id: Int = -1,
    @Json(name = "phone") val phone: String = "00000000",
    @Json(name = "email") val email: String = "",
    @Json(name = "name") val name: String = "Ola Normann",
    @Json(name = "birth_year") val birthYear: Int = -1
    ) {
    fun ApiToDB(user: User): UserTable {
        return UserTable(
            liveID = user.id,
            phone = user.phone,
            email = user.email,
            name = user.name,
            birthYear = user.birthYear
        )
    }
}