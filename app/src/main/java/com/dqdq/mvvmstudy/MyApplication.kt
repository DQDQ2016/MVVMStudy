package com.dqdq.mvvmstudy

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}