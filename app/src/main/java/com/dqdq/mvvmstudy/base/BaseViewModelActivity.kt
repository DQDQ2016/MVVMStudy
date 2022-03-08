package com.dqdq.mvvmstudy.base

import com.dqdq.mvvmstudy.model.BaseViewModel
import com.dqdq.mvvmstudy.model.viewModelDelegate
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import kotlin.reflect.KClass

abstract class BaseViewModelActivity<vm:BaseViewModel>: BaseActivity() {

    var vm : vm = viewModelDelegate(getViewModelClazz()).buildViewModel(this)

    abstract fun getViewModelClazz(): KClass<vm>

}