package com.dqdq.mvvmstudy.base

import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.minterface.IDataBinding
import com.dqdq.mvvmstudy.minterface.holder.dataBindingHolder

/**
 * Created by DQDQ on 10/3/2022
 */
abstract class BaseViewModelDataBindingActivity<V: ViewDataBinding,vm: BaseViewModel>:
    BaseViewModelActivity<vm>(), IDataBinding<V> by dataBindingHolder() {

    override fun initView() {
        super.initView()
        inflate {
            onDataBinding() }
        onBindVariableID().forEach {
            requireBinding().setVariable(it.first,it.second)
        }
        requireBinding().lifecycleOwner = this
        initObservable()
    }

    abstract fun initObservable()

    abstract fun onDataBinding():V

    abstract fun onBindVariableID():MutableList<Pair<Int,Any>>
}