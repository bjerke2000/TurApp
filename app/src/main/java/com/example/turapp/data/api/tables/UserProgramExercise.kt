package com.example.turapp.data.api.tables

import com.example.turapp.data.database.userexercise.UserExerciseTable
import com.squareup.moshi.Json

data class UserProgramExercise (
    @Json(name = "id") val id : Int = -1,
    @Json(name = "user_program_id") val userProgramId: Int = -1,
    @Json(name = "user_exercise_id") val userExerciseId: Int = -1
    )