package com.dqdq.mvvmstudy.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dqdq.mvvmstudy.model.BaseViewModel
import com.dqdq.mvvmstudy.model.utils.RxJavaUtils
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.lang.StringBuilder
import java.util.concurrent.TimeUnit

class LoginModelView : BaseViewModel() {

    var liveUserName: MutableLiveData<String>? = null
    var livePassWord: MutableLiveData<String>? = null


    open fun currentUserName():MutableLiveData<String>{
        if (liveUserName == null)
            liveUserName = MutableLiveData()
        return liveUserName as MutableLiveData<String>
    }

    open fun currentPassword():MutableLiveData<String>{
        if (livePassWord == null)
            livePassWord = MutableLiveData()
        return livePassWord as MutableLiveData<String>
    }

    open fun userLogin(){
        if(liveUserName?.value?.isEmpty() == true
            &&livePassWord?.value?.isEmpty() == true){
        }else{

        }
    }

    companion object{
        val TAG = this.javaClass.simpleName
    }

}