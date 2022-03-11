package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.dqdq.mvvmstudy.minterface.IDataBinding
import com.dqdq.mvvmstudy.minterface.holder.dataBindingHolder
import com.dqdq.mvvmstudy.model.ext.viewModelDelegate
import kotlin.reflect.KClass
/**
 * Created by DQDQ on 10/3/2022
 */
abstract class BaseModelViewBindingFragment<v:ViewDataBinding,vm:BaseViewModel>
    : BaseViewModelFragment<vm>(), IDataBinding<v> by dataBindingHolder() {

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

    abstract fun onDataBinding():v

    abstract fun onBindVariableID():MutableList<Pair<Int,Any>>

}