package com.dqdq.mvvmstudy.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.model.viewModelDelegate


class MainActivity : BaseActivity() {

    private lateinit var loginModelView :LoginModelView
    private lateinit var binding :ActivityMainBinding
    val TAG = this.javaClass.simpleName

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.lifecycleOwner = this
        Log.i(TAG,"initView")
        lifecycle.addObserver(DefaultLifeCycle())
        loginModelView = viewModelDelegate(LoginModelView::class).buildViewModel(this)
        binding.vm = loginModelView
    }

    override fun initData() {
        super.initData()
        Log.i(TAG,"initData")
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when(v.id){
            R.id.btnLogin->{

            }
        }
    }
}