package com.dqdq.mvvmstudy.model

import androidx.lifecycle.ViewModelProvider
import com.dqdq.mvvmstudy.base.BaseActivity
import com.dqdq.mvvmstudy.base.BaseFragment
import kotlin.reflect.KClass

class ViewModelDelegate<out T: BaseViewModel>(private val clazz: KClass<T>
    ,private val fromActivity:Boolean = true) {

    private var modelView:T? =null

    @JvmOverloads
    fun buildViewModel(activity: BaseActivity? = null, fragment: BaseFragment? = null):T{
        if (modelView!=null)
            return modelView as T
        activity?.let {
            modelView = ViewModelProvider(it)[clazz.java]
        }?:fragment?.let {
            modelView = if (!fromActivity)
                ViewModelProvider(it,ViewModelProvider.NewInstanceFactory())[clazz.java]
            else
                ViewModelProvider(it.requireActivity())[clazz.java]
        }
        return modelView!!
    }
}

fun <T:BaseViewModel> viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz,true)