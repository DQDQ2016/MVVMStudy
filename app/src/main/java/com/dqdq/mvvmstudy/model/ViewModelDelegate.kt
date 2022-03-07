package com.dqdq.mvvmstudy.model

import androidx.lifecycle.ViewModelProvider
import com.dqdq.mvvmstudy.activity.BaseActivity
import kotlin.reflect.KClass

class ViewModelDelegate<out T: BaseViewModel>(private val clazz: KClass<T>
    ,private val fromActivity:Boolean = true) {

    private var modelView:T? =null

    private fun buildViewModel(activity:BaseActivity):T{
        if (modelView!=null)
            return modelView as T
        activity?.let {
            modelView = ViewModelProvider(activity)[clazz.java]
        }

        return modelView!!
    }
}

fun <T:BaseViewModel> BaseActivity.viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz,true)