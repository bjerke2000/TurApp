package com.example.turapp.data.database.usertable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.turapp.data.api.tables.User

@Entity(tableName = "user")
data class UserTable (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "live_id")
    val liveID: Int,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "birth_year")
    val birthYear: Int
        ) {
    fun DBToApi(user: UserTable): User {
        return User(
            id = user.liveID,
            phone = user.phone,
            email = user.email,
            name = user.name,
            birthYear = user.birthYear
        )
    }
}