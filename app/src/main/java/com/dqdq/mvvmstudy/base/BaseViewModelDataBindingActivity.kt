package com.dqdq.mvvmstudy.base

import androidx.viewbinding.ViewBinding
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.minterface.IDataBinding
import com.dqdq.mvvmstudy.minterface.holder.dataBindingHolder

/**
 * Created by DQDQ on 10/3/2022
 */
abstract class BaseViewModelDataBindingActivity<V: ViewBinding,vm: BaseViewModel>:
    BaseViewModelActivity<vm>(), IDataBinding<V> by dataBindingHolder() {

    override fun initView() {
        super.initView()
        inflate { onDataBinding() }
    }

    abstract fun onDataBinding():V

    abstract fun onBindVariableID():MutableList<Pair<Int,Any>>
}