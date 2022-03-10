package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass
/**
 * Created by DQDQ on 10/3/2022
 */
abstract class BaseModelViewBindingFragment<vm:BaseViewModel> : BaseFragment() {

    val vm : vm by lazy { viewModelDelegate(getViewModelClazz()).buildViewModel(
        requireActivity() as BaseActivity,this) }

    abstract fun getViewModelClazz(): KClass<vm>

}