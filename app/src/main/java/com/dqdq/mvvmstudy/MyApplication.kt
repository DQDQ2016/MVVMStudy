package com.dqdq.mvvmstudy

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
/**
 * Created by DQDQ on 9/3/2022
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}