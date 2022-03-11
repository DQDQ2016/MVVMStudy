package com.dqdq.mvvmstudy.minterface.holder

import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.dqdq.mvvmstudy.minterface.IDataBinding
import com.dqdq.mvvmstudy.minterface.IDataBindingHolder
/**
 * Created by DQDQ on 10/3/2022
 */
class DataBindingHolder<T : ViewDataBinding>:IDataBinding<T> {

    private val dataBindingHolder = IDataBindingHolder.BindingHolder<T>()

    override fun requireBinding(): T = dataBindingHolder.requireBinding()

    override fun inflate(b: () -> T) {
        dataBindingHolder.bind(b())
    }
}

fun <T:ViewDataBinding> dataBindingHolder(): IDataBinding<T>
    = DataBindingHolder<T>()