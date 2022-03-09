package com.dqdq.mvvmstudy.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dqdq.mvvmstudy.base.BaseViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginModelView(application: Application) : BaseViewModel(application) {

    var loginCallBack :((Boolean) -> Unit)? = null

    fun userLogin(userName:String,pwd:String){
        MainScope().launch {
            delay(1000)
            if(userName.isEmpty() || pwd.isEmpty()){
                loginCallBack?.let { it(false) }
            }else{
                loginCallBack?.let { it(true) }
            }
        }
    }
}