package com.example.turapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.turapp.data.database.usertable.UserTable
import com.example.turapp.data.database.usertable.UserTableDao

@Database( entities = [UserTable::class], version=2, exportSchema = false)
abstract class TripRoomDatabase: RoomDatabase() {
    abstract fun userTableDao(): UserTableDao
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