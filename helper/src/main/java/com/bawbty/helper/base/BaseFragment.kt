package com.bawbty.helper.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.bawbty.helper.core.SharedPreferencesHelper
import org.koin.android.ext.android.inject

/**
 * Created by khairy on خ, 23/ماي/2019 at 09:29 ص.
 * mohamed.khairy@apptcom.com
 */
open class BaseFragment(@LayoutRes val layoutRes: Int) : Fragment() {
    val sharedPref by inject<SharedPreferencesHelper>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }
}