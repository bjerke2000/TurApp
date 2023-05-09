package com.example.turapp.di

import android.content.Context
import com.example.turapp.data.database.TripRepository
import com.example.turapp.data.database.TripRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context): TripRoomDatabase {
        return TripRoomDatabase.getDatabase(context)
    }

    @Provides
    fun provideTripRepository(database: TripRoomDatabase): TripRepository {
        return TripRepository(database.appProgramTypeDao(),  database.userProgramDao(), database.userProgramSessionDao(), database.userExerciseDao(), database.userTableDao())
    }

}