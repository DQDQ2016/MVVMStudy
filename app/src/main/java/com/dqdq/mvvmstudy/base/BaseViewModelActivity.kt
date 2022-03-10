package com.dqdq.mvvmstudy.base

import androidx.databinding.ViewDataBinding
import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass
/**
 * Created by DQDQ on 9/3/2022
 */
abstract class BaseViewModelActivity<vm: BaseViewModel>: BaseActivity() {

    val vm : vm by lazy { viewModelDelegate(getViewModelClazz()).buildViewModel(this) }
    abstract fun getViewModelClazz(): KClass<vm>

}