package com.bawbty.application

import android.app.Application
import android.content.Context


open class BaseApplicationClass : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance = BaseApplicationClass()
        fun get(): Context {
            return instance
        }
    }
}
