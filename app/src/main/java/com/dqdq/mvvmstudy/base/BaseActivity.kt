package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.model.BaseViewModel
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlin.reflect.KClass

abstract class BaseActivity: RxAppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
        initListener()
    }


    open fun initData(){

    }

    open fun initView(){
        binding = DataBindingUtil.setContentView(
            this, onBindLayout())
        binding.lifecycleOwner = this
        lifecycle.addObserver(DefaultLifeCycle())
    }

    open fun initListener(){

    }

    open fun onClick(v: View){

    }

    abstract fun onBindLayout(): Int

}