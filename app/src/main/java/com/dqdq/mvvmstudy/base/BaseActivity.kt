package com.dqdq.mvvmstudy.base

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.lifecycle.DefaultLifeCycle
import com.dqdq.mvvmstudy.model.utils.DialogUtils
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity: RxAppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val TAG: String by lazy{ this.javaClass.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
        initListener()
    }

    open fun initData(){

    }

    open fun initView(){
        binding = DataBindingUtil.setContentView(
            this, onBindLayout())
        binding.lifecycleOwner = this
        lifecycle.addObserver(DefaultLifeCycle())
    }

    open fun initListener(){

    }

    open fun onClick(v: View){

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