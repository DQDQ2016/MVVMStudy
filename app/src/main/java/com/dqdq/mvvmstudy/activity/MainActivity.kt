package com.dqdq.mvvmstudy.activity

import android.util.Log
import android.view.View
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.base.BaseViewModelActivity
import com.dqdq.mvvmstudy.model.utils.DialogUtils
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import com.dqdq.mvvmstudy.model.utils.makeToast
import kotlinx.coroutines.delay
import kotlin.reflect.KClass

class MainActivity : BaseViewModelActivity<LoginModelView>() {

    override fun initView() {
        super.initView()
        binding.vm = vm
    }

    override fun initListener() {
        super.initListener()
        vm.loginCallBack = {
            cancelLoadingProgress()
            if (!it)
                "登录失败".makeToast(this)
            else
                "登录成功".makeToast(this)
                    .also {
                        startActivity(HomePageActivity::class.java)
                        finish()
                    }
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when(v.id){
            R.id.btnLogin -> vm.userLogin(binding.editName.text.toString()
                ,binding.editPwd.text.toString()).also { showLoadingProgress() }
        }
    }

    override fun enableDataBinding(): Boolean = true
    override fun enableLifecycle(): Boolean = true
    override fun onBindLayout(): Int = R.layout.activity_main
    override fun getViewModelClazz(): KClass<LoginModelView> =  LoginModelView::class

}