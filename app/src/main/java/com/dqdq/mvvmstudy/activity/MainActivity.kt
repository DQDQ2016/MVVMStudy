package com.dqdq.mvvmstudy.activity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.model.retrofit.RetrofitManager
import com.dqdq.mvvmstudy.model.utils.RxJavaUtils
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import io.reactivex.Observable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dqdq.mvvmstudy.model.viewModelDelegate
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.coroutines.flow.asFlow
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {

    private lateinit var loginModelView:LoginModelView

    val TAG = this.javaClass.simpleName

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(DefaultLifeCycle())
        val loginModelView = viewModelDelegate(LoginModelView::class)
//        RetrofitManager.get().apiService().publicEvent("DQDQ2016")
//            .doOnDispose{Log.i(TAG,"i am quit")}
//            .delay(1000,TimeUnit.MILLISECONDS)
//            .compose(RxJavaUtils.observerToMain())
//            .compose(bindUntilEvent(ActivityEvent.DESTROY))
//            .flatMap {
//                Observable.fromIterable(it.toList())
//            }
//            .subscribe(
//                {
//                    Log.i(TAG,it.toString())
//                },
//                {
//                    Log.i(TAG,it.message?:"")
//                },{
//                    Log.i(TAG,"complete")
//                }
//            )
    }

}