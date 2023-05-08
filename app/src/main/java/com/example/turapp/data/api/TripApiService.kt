package com.example.turapp.data.api

import com.example.turapp.data.api.tables.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private const val BASE_URL =
    "https://wfa-media.com/exercise23/v3/api.php/"
private const val API_KEY = "004E0CD0-E02"
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("User-Agent", "android")
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", API_KEY)
            .build()
        chain.proceed(request)
    }
    .build()
private val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object TripApi {
    val retrofitService : TripApiService by lazy {
        retrofit.create(TripApiService::class.java) }
}

interface TripApiService {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id : Int): User

    @GET("users")
    suspend fun getUserByPhone(@Query("phone") phone:String): List<User>

    @GET("user_program/{id}")
    suspend fun getUserProgram(@Path("id") id: Int): UserProgram


    @GET("user_program")
    suspend fun getAllUserPrograms(): List<UserProgram>


    @GET("user_exercise/{id}")
    suspend fun getUserExercise(@Path("id") id: Int): UserExercise


    @GET("user_exercise")
    suspend fun getAllUserExercises(): List<UserExercise>


    @GET("app_program_type/{id}")
    suspend fun getAppProgramType(@Path("id") id: Int): AppProgramType


    @GET("app_program_type")
    suspend fun getAllAppProgramTypes(): List<AppProgramType>


    @GET("user_program_session/{id}")
    suspend fun getUserProgramSession(@Path("id") id: Int): UserProgramSession


    @GET("user_program_session")
    suspend fun getAllUserProgramSessions(): List<UserProgramSession>


    @GET("user_program_session_data")
    suspend fun getUserProgramSessionData(): List<UserProgramSessionData>


    @GET("user_program_session_photo")
    suspend fun getUserProgramSessionPhoto(): List<UserProgramSessionPhoto>

}