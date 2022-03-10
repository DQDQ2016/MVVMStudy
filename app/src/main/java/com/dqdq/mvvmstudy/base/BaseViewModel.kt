package com.dqdq.mvvmstudy.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
/**
 * Created by DQDQ on 7/3/2022
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val TAG: String by lazy{ this.javaClass.simpleName }

}