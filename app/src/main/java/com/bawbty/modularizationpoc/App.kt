package com.bawbty.modularizationpoc

import com.bawbty.application.BaseApplicationClass
import com.bawbty.database.AppDatabase
import com.bawbty.database.di.databaseModule
import com.bawbty.login.di.featureLoginModule
import com.bumptech.glide.request.target.ImageViewTarget
import networkModule
import org.koin.android.ext.android.startKoin
import sharedPrefModule

/*
* Created by Khairy at 8/19/2019
* mohamedsallam953@gmail.com
*/

class App : BaseApplicationClass() {
    override fun onCreate() {
        super.onCreate()
        ImageViewTarget.setTagId(R.id.glide_custom_view_target_tag)
       // AppDatabase.getAppDatabase(this)
        startKoin(
            androidContext = this@App,
            modules = listOf(sharedPrefModule, databaseModule, networkModule, featureLoginModule)
        )
    }
}