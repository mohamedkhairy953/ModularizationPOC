package com.bawbty.login.di

import com.bawbty.database.AppDatabase
import com.bawbty.database.login.UserDao
import com.bawbty.login.model.remote.LoginWebServices
import com.bawbty.login.model.repo.LoginRepo
import com.bawbty.login.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

/**
 * Created by khairy on ن, 20/ماي/2019 at 10:52 ص.
 * mohamed.khairy@apptcom.com
 */

var featureLoginModule = module {
    single { provideDao(get()) }
    factory { provideRegisterApi(get()) }
    single { provideLoginRepo(get(), get()) }
    viewModel { provideLoginViewModel(get()) }
}

fun provideDao(get: AppDatabase) = get.userDao()

fun provideLoginRepo(api: LoginWebServices, get1: UserDao) = LoginRepo(api, get1)

fun provideLoginViewModel(get: LoginRepo) = LoginViewModel(get)


fun provideRegisterApi(retrofit: Retrofit): LoginWebServices {
    return retrofit.create(LoginWebServices::class.java)
}
