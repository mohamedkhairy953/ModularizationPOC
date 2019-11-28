package com.bawbty.login.model.repo

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.bawbty.database.login.User
import com.bawbty.database.login.UserDao
import com.bawbty.helper.livedata.Resource
import com.bawbty.helper.utilities.NetworkUtils
import com.bawbty.helper.utilities.ShouldFetch
import com.bawbty.login.model.remote.LoginWebServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import log
import java.io.IOException

/**
 * Created by Khairy at 8/20/2019
 * mohamedsallam953@gmail.com
 */

class LoginRepo(private val webservice: LoginWebServices, private val userDao: UserDao) {

    fun getUser(id: String) = liveData<Resource<User>> {
        val disposable = emitSource(
            userDao.retrieveUser("10").map {
                Resource.loading(it)
            }
        )
        try {
            val userResp = webservice.fetchUser()
            disposable.dispose()
            userDao.insert(userResp.user)
            emitSource(
                userDao.retrieveUser("10").map {
                    Resource.success(it)
                }
            )
        } catch (exception: IOException) {
            emitSource(
                userDao.retrieveUser(id).map {
                    Resource.error(exception,it)
                }
            )
        }
    }
}