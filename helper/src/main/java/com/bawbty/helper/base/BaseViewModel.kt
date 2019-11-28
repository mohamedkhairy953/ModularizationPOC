package com.bawbty.helper.base
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bawbty.helper.livedata.SingleLiveEvent

/**
 * Created by khairy on ر, 22/ماي/2019 at 01:54 م.
 * mohamed.khairy@apptcom.com
 */
open class BaseViewModel : ViewModel() {
    val dataLoading = MutableLiveData<Boolean>()
    val showNoNetworkScreenEvent = MutableLiveData<Boolean>()
    val showNoListScreenEvent = SingleLiveEvent<Boolean>()
    var errorMessageEvent = SingleLiveEvent<String>()
    var successMessageEvent = SingleLiveEvent<String>()
}