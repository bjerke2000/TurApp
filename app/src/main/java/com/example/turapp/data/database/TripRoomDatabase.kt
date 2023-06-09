package com.example.turapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.turapp.data.database.app_program_type.AppProgramTypeTable
import com.example.turapp.data.database.app_program_type.AppProgramTypeDao
import com.example.turapp.data.database.user_program.UserProgramTable
import com.example.turapp.data.database.user_program.UserProgramDao
import com.example.turapp.data.database.user_program_session.UserProgramSessionTable
import com.example.turapp.data.database.user_program_session.UserProgramSessionDao
import com.example.turapp.data.database.userexercise.UserExerciseTable
import com.example.turapp.data.database.userexercise.UserExerciseDao
import com.example.turapp.data.database.usertable.UserTable
import com.example.turapp.data.database.usertable.UserTableDao

@Database( entities = [
    UserTable::class,
    UserProgramTable::class,
    UserProgramSessionTable::class,
    UserExerciseTable::class,
    AppProgramTypeTable::class], version=3, exportSchema = false)
abstract class TripRoomDatabase: RoomDatabase() {
    abstract fun userTableDao(): UserTableDao
    abstract fun userProgramDao(): UserProgramDao
    abstract fun userProgramSessionDao(): UserProgramSessionDao
    abstract fun userExerciseDao(): UserExerciseDao
    abstract fun appProgramTypeDao(): AppProgramTypeDao
    companion object {
        @Volatile
        private var INSTANCE: TripRoomDatabase? = null
        fun getDatabase(context: Context): TripRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, TripRoomDatabase::class.java,
                    "trip_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}