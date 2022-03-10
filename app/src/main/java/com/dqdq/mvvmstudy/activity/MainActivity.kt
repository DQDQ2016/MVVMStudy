package com.dqdq.mvvmstudy.activity

import android.view.View
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.minterface.IActivityDataBinding
import com.dqdq.mvvmstudy.base.BaseViewModelActivity
import com.dqdq.mvvmstudy.minterface.holder.activityDataBindingHolder
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import com.dqdq.mvvmstudy.model.utils.makeToast
import kotlin.reflect.KClass

class MainActivity : BaseViewModelActivity<LoginModelView>()
    , IActivityDataBinding<ActivityMainBinding> by activityDataBindingHolder(){

    override fun initView() {
        super.initView()
        baseView?.let {
            inflate { ActivityMainBinding.bind(it) }
        }
    }

    override fun initListener() {
        super.initListener()
        var result = MutableList(0) { 0 }
        result.add(1)
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
            R.id.btnLogin -> vm.userLogin(requireBinding().editName.text.toString()
                ,requireBinding().editPwd.text.toString()).also { showLoadingProgress() }
        }
    }


    override fun enableLifecycle(): Boolean = true
    override fun onBindLayout(): Int = R.layout.activity_main
    override fun getViewModelClazz(): KClass<LoginModelView> =  LoginModelView::class
}