package com.dqdq.mvvmstudy.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dqdq.mvvmstudy.base.BaseViewModel
import com.dqdq.mvvmstudy.model.bean.Event
import com.dqdq.mvvmstudy.model.retrofit.RetrofitManager
import com.dqdq.mvvmstudy.model.utils.RxJavaUtils

/**
 * Created by DQDQ on 10/3/2022
 */
class NetListViewModel(application: Application) : BaseViewModel(application) {

    private var listData: MutableLiveData<MutableList<Event>>? = null

    fun currentListData():MutableLiveData<MutableList<Event>>{
        if (listData==null)
            listData = MutableLiveData()
        return listData as MutableLiveData <MutableList<Event>>
    }

    @SuppressLint("CheckResult")
    fun getListData(){
        RetrofitManager.get().apiService().publicEvent("DQDQ2016")
            .compose(RxJavaUtils.observerToMain())
            .subscribe({
                    Log.i(TAG,"success")
                    currentListData().value = it
                },{
                    Log.i(TAG,"error:"+it.message.toString())
                },{}
            )
    }

}