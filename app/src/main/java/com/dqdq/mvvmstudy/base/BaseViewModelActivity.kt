package com.dqdq.mvvmstudy.base

import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass

abstract class BaseViewModelActivity<vm: BaseViewModel>: BaseActivity() {

    val vm : vm by lazy { viewModelDelegate(getViewModelClazz()).buildViewModel(this) }

    abstract fun getViewModelClazz(): KClass<vm>

}