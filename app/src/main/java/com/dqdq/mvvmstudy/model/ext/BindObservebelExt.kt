package com.dqdq.mvvmstudy.model.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Created by DQDQ on 11/3/2022
 */
fun <T> LifecycleOwner.observe(livedata:LiveData<T>,action:(t:T)->Unit){
    livedata.observe(this,action)
}