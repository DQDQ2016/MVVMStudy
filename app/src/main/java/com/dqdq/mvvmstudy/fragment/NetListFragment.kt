package com.dqdq.mvvmstudy.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.window.Dialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dqdq.mvvmstudy.BR
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.base.BaseModelViewBindingFragment
import com.dqdq.mvvmstudy.databinding.FragmentNetListBinding
import com.dqdq.mvvmstudy.model.ext.observe
import com.dqdq.mvvmstudy.view.adapter.NetListAdapter
import com.dqdq.mvvmstudy.viewModel.NetListViewModel
import kotlin.reflect.KClass

/**
 * Created by DQDQ on 9/3/2022
 */
class NetListFragment : BaseModelViewBindingFragment<FragmentNetListBinding,NetListViewModel>() {

    var mAdapter:NetListAdapter? = null

    companion object {
        @JvmStatic
        fun newInstance() = NetListFragment()
    }

    override fun onBindLayout(): Int = R.layout.fragment_net_list

    override fun initView() {
        super.initView()
        mAdapter = NetListAdapter()
        requireBinding().rcvList.layoutManager = LinearLayoutManager(requireContext())
        requireBinding().rcvList.adapter = mAdapter
        vm.getListData()
    }

    override fun initObservable() {
        observe(vm.currentListData()){
            Log.i(TAG,"change change")
            mAdapter?.setList(it)
        }
    }

    override fun onDataBinding(): FragmentNetListBinding = mView?.let { FragmentNetListBinding.bind(it) }!!

    override fun onBindVariableID(): MutableList<Pair<Int, Any>> {
        return arrayListOf(BR.vm to vm)
    }

    override fun getViewModelClazz(): KClass<NetListViewModel> = NetListViewModel::class
}