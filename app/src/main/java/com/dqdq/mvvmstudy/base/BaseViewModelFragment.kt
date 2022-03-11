package com.dqdq.mvvmstudy.base

import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass

/**
 * Created by DQDQ on 10/3/2022
 */
abstract class BaseViewModelFragment<vm:BaseViewModel>: BaseFragment() {

    val vm : vm by lazy { viewModelDelegate(getViewModelClazz()).buildViewModel(
        requireActivity() as BaseActivity,this) }

    abstract fun getViewModelClazz(): KClass<vm>
}