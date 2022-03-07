package com.dqdq.mvvmstudy.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

open class BaseActivity: RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    open fun initData(){

    }

    open fun initView(){

    }

    open fun onClick(v: View){

    }

}