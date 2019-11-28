package com.bawbty.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bawbty.database.login.User
import com.bawbty.helper.base.BaseViewModel
import com.bawbty.helper.livedata.Resource
import com.bawbty.helper.utilities.ShouldFetch
import com.bawbty.login.model.repo.LoginRepo
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

/**
 * Created by Khairy at 8/20/2019
 * mohamedsallam953@gmail.com
 */

class LoginViewModel(private val repo: LoginRepo) : BaseViewModel() {

    fun getUserAsync(id: String): Deferred<LiveData<Resource<User>>> {
        if(!ShouldFetch.networkRecommended()){
            showNoNetworkScreenEvent.value=true
        }
       return viewModelScope.async { repo.getUser(id) }
    }
}