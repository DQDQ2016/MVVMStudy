package com.dqdq.mvvmstudy.lifecycle

import android.util.Log
import androidx.lifecycle.*
/**
 * Created by DQDQ on 7/3/2022
 */
class DefaultLifeCycle :DefaultLifecycleObserver {

    companion object{
        const val TAG = "DefaultLifeCycle"
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(TAG,"onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.i(TAG,"onStart")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG,"onDestroy")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(TAG,"onPause")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(TAG,"onResume")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.i(TAG,"onStop")
    }
}