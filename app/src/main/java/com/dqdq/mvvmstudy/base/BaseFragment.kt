package com.dqdq.mvvmstudy.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.fragment.NetListFragment
import com.dqdq.mvvmstudy.model.utils.DialogUtils
import com.trello.rxlifecycle2.components.RxFragment
/**
 * Created by DQDQ on 7/3/2022
 */
abstract class BaseFragment: com.trello.rxlifecycle2.components.support.RxFragment() {

    var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(onBindLayout(), container, false)
        return mView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        initView()
        initData()
        initListener()
    }

    private fun initView(){

    }

    private fun initData(){

    }
    private fun initListener(){

    }

    private val loadingDialog: Dialog by lazy { DialogUtils.getLoadingDialog(requireActivity()) }

    open fun showLoadingProgress() = loadingDialog.show()

    open fun cancelLoadingProgress() = loadingDialog.cancel()

    abstract fun enableDataBinding(): Boolean

    abstract fun onBindLayout(): Int

}