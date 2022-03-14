package com.dqdq.mvvmstudy.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.model.utils.DialogUtils
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import java.util.zip.Inflater
/**
 * Created by DQDQ on 7/3/2022
 */
abstract class BaseActivity: RxAppCompatActivity() {

    var baseView :View? = null
    val TAG: String by lazy{ this.javaClass.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        initView()
        initData()
        initListener()
        initLifecycle()
    }

    open fun initData(){

    }

    open fun initView(){
        baseView = View.inflate(this,onBindLayout(),null)
        setContentView(baseView)
    }

    open fun initListener(){

    }

    open fun onClick(v: View){

    }

    open fun initLifecycle(){

    }

    @JvmOverloads
    open fun startActivity(clz: Class<*>?, bundle: Bundle? = null) {
        val intent = Intent(this, clz)
        bundle?.let { intent.putExtras(bundle) }
        startActivity(intent)
    }

    private val loadingDialog:Dialog by lazy { DialogUtils.getLoadingDialog(this) }

    open fun showLoadingProgress() = loadingDialog.show()

    open fun cancelLoadingProgress() = loadingDialog.cancel()

    abstract fun onBindLayout(): Int
}