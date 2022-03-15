package com.dqdq.mvvmstudy.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dqdq.mvvmstudy.BR
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.base.BaseModelViewBindingFragment
import com.dqdq.mvvmstudy.databinding.FragmentDataBaseBinding
import com.dqdq.mvvmstudy.model.ext.observe
import com.dqdq.mvvmstudy.viewModel.DataListViewModel
import com.dqdq.mvvmstudy.viewModel.NetListViewModel
import kotlin.reflect.KClass

/**
 * Created by DQDQ on 9/3/2022
 */
class DataBaseFragment: BaseModelViewBindingFragment<FragmentDataBaseBinding, DataListViewModel>() {


    override fun onBindLayout(): Int = R.layout.fragment_data_base

    companion object {
        @JvmStatic
        fun newInstance() =
            DataBaseFragment()
    }

    override fun initData() {
        super.initData()
        vm.currentCount().postValue(1)
    }

    override fun initListener() {
        super.initListener()
        requireBinding().tvCount.setOnClickListener {
            vm.currentCount().value = vm.currentCount().value?.plus(1)
        }
    }

    override fun initObservable() {
        observe(vm.currentCount()) {
            Log.i(TAG,"change change")
        }
    }

    override fun onDataBinding(): FragmentDataBaseBinding = mView?.let { FragmentDataBaseBinding.bind(it)}!!

    override fun onBindVariableID(): MutableList<Pair<Int, Any>> {
        return arrayListOf(BR.vm to vm)
    }

    override fun getViewModelClazz(): KClass<DataListViewModel> = DataListViewModel::class
}