package com.dqdq.mvvmstudy.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dqdq.mvvmstudy.base.BaseViewModel
import com.dqdq.mvvmstudy.model.retrofit.RetrofitManager
import com.dqdq.mvvmstudy.model.utils.RxJavaUtils
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
/**
 * Created by DQDQ on 8/3/2022
 */
class LoginModelView(application: Application) : BaseViewModel(application) {

    var loginCallBack :((Boolean) -> Unit)? = null

    @SuppressLint("CheckResult")
    fun userLogin(userName:String, pwd:String){

        MainScope().launch {
            delay(100)
            if(userName.isEmpty() || pwd.isEmpty()){
                loginCallBack?.let { it(false) }
            }else{
                loginCallBack?.let { it(true) }
            }
        }
    }

}