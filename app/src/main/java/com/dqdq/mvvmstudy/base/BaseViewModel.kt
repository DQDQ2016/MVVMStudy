package com.dqdq.mvvmstudy.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val TAG: String by lazy{ this.javaClass.simpleName }

}