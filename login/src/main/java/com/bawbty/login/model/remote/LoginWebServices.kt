package com.bawbty.login.model.remote

import com.bawbty.database.login.User
import com.bawbty.login.model.UserResponse
import retrofit2.http.GET

/**
* Created by Khairy at 8/20/2019
* mohamedsallam953@gmail.com
*/

interface LoginWebServices {
    @GET("login")
    suspend fun fetchUser(): UserResponse
}