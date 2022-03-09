package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.trello.rxlifecycle2.components.RxFragment

abstract class BaseFragment: com.trello.rxlifecycle2.components.support.RxFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

}