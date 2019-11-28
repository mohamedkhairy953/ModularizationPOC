package com.bawbty.login.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bawbty.helper.alerts.UiMessagesUtils
import com.bawbty.helper.base.BaseFragment
import com.bawbty.helper.livedata.Resource
import com.bawbty.login.R
import com.bawbty.login.databinding.FragmentLoginBinding
import com.bawbty.login.viewmodel.LoginViewModel
import kotlinx.coroutines.launch
import log
import makeVisibleWhen
import navigate
import observeNoNetworkToast
import org.koin.android.viewmodel.ext.android.viewModel
import showErrorToastWhen

class LoginFragment : BaseFragment(R.layout.fragment_login) {
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bind = FragmentLoginBinding.bind(view)
        bind.viewModel = viewModel
        bind.tv.setOnClickListener {
            navigate(R.id.action_loginFragment_to_registerFragment)
        }
        lifecycleScope.launch {
            viewModel.getUserAsync("2").await().observe(viewLifecycleOwner, Observer {
                bind.progressbar.makeVisibleWhen(it.isLoading())
                showErrorToastWhen(it.isError(), it.error)
                if (it.shouldBind()) {
                    log("fff")
                    bind.tv.text = it.data?.name
                }
            })
        }
        // observeNoNetworkToast(viewModel.showNoNetworkScreenEvent,R.string.general_error_network)
    }
}

