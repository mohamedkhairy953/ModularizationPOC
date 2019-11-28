package com.bawbty.database.di

import android.app.Application
import androidx.room.Room
import com.bawbty.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * Created by Khairy at 8/20/2019
 * mohamedsallam953@gmail.com
 */

val databaseModule= module{
    single { provideAppDataBase(androidApplication()) }
}

fun provideAppDataBase(app: Application): AppDatabase {
    return Room.databaseBuilder(app, AppDatabase::class.java, "itis_bawbty.db")
        .fallbackToDestructiveMigration()
        .build()
}