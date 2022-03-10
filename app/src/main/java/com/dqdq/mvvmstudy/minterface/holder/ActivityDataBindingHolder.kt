package com.dqdq.mvvmstudy.minterface.holder

import androidx.viewbinding.ViewBinding
import com.dqdq.mvvmstudy.minterface.IActivityDataBinding
import com.dqdq.mvvmstudy.minterface.IDataBindingHolder

class ActivityDataBindingHolder<T : ViewBinding>:IActivityDataBinding<T> {

    private val dataBindingHolder = IDataBindingHolder.BindingHolder<T>()

    override fun requireBinding(): T = dataBindingHolder.requireBinding()

    override fun inflate(b: () -> T) {
        dataBindingHolder.bind(b())
    }
}

fun <T:ViewBinding> activityDataBindingHolder(): IActivityDataBinding<T>
    = ActivityDataBindingHolder<T>()