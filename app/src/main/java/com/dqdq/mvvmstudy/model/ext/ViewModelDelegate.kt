package com.dqdq.mvvmstudy.model.ext

import androidx.lifecycle.ViewModelProvider
import com.dqdq.mvvmstudy.base.BaseActivity
import com.dqdq.mvvmstudy.base.BaseFragment
import com.dqdq.mvvmstudy.base.BaseViewModel
import kotlin.reflect.KClass
/**
 * Created by DQDQ on 7/3/2022
 */
class ViewModelDelegate<out T: BaseViewModel>(private val clazz: KClass<T>
                                              , private val fromActivity:Boolean = true) {

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

fun <T: BaseViewModel> BaseActivity.viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz,true)

fun <T: BaseViewModel> BaseFragment.viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz,true)