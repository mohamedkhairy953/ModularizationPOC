package com.bawbty.database

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bawbty.database.login.User
import com.bawbty.database.login.UserDao


@Database(version = 1, exportSchema = false, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {

    // DAO
    abstract fun userDao(): UserDao


}