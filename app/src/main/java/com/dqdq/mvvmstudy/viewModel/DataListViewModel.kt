package com.dqdq.mvvmstudy.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.dqdq.mvvmstudy.base.BaseViewModel

/**
 * Created by DQDQ on 14/3/2022
 */
class DataListViewModel(application: Application) : BaseViewModel(application) {
    var count: MutableLiveData<Int>? = null

    fun currentCount(): MutableLiveData<Int>{
        if (count == null)
            count = MutableLiveData()
        return count as MutableLiveData<Int>
    }
}