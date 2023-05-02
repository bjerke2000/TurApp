package com.example.turapp.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private const val BASE_URL =
    "https://wfa-media.com/exercise23/v3/api.php/"
private const val API_KEY = "a1b2c3d4"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object TripApi {
    val retrofitService : TripApiService by lazy {
        retrofit.create(TripApiService::class.java) }
}

interface TripApiService {

}