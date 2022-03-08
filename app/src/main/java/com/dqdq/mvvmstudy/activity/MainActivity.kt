package com.dqdq.mvvmstudy.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.base.BaseActivity
import com.dqdq.mvvmstudy.base.BaseViewModelActivity
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.model.BaseViewModel
import com.dqdq.mvvmstudy.model.utils.makeToast
import com.dqdq.mvvmstudy.model.viewModelDelegate
import kotlin.reflect.KClass

class MainActivity : BaseViewModelActivity<LoginModelView>() {

    val TAG = this.javaClass.simpleName

    override fun initView() {
        super.initView()
        binding.vm = vm
    }

    override fun initData() {
        super.initData()
        Log.i(TAG,"initData")
    }

    override fun initListener() {
        super.initListener()
        vm.loginCallBack = {
            if (!it)
                "登录失败".makeToast(this)
            else{

            }
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when(v.id){
            R.id.btnLogin -> vm.userLogin()
        }
    }

    override fun onBindLayout(): Int = R.layout.activity_main
    override fun getViewModelClazz(): KClass<LoginModelView> =  LoginModelView::class

}