package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass

abstract class BaseModelViewBindingFragment<vm:BaseViewModel> : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    val vm : vm by lazy { viewModelDelegate(getViewModelClazz()).buildViewModel(
        requireActivity() as BaseActivity,this) }

    abstract fun getViewModelClazz(): KClass<vm>

    abstract fun onBindLayout(): Int
}