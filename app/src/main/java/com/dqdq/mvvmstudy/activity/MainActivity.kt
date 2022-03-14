package com.dqdq.mvvmstudy.activity

import android.util.Log
import android.view.View
import com.dqdq.mvvmstudy.BR
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.minterface.IDataBinding
import com.dqdq.mvvmstudy.base.BaseViewModelActivity
import com.dqdq.mvvmstudy.base.BaseViewModelDataBindingActivity
import com.dqdq.mvvmstudy.databinding.ActivityMainBinding
import com.dqdq.mvvmstudy.minterface.holder.dataBindingHolder
import com.dqdq.mvvmstudy.model.ext.observe
import com.dqdq.mvvmstudy.viewModel.LoginModelView
import com.dqdq.mvvmstudy.model.utils.makeToast
import kotlin.reflect.KClass
/**
 * Created by DQDQ on 6/3/2022
 */
class MainActivity : BaseViewModelDataBindingActivity<ActivityMainBinding, LoginModelView>() {

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
            R.id.btnLogin -> vm.userLogin(requireBinding().editName.text.toString()
                ,requireBinding().editPwd.text.toString()).also { showLoadingProgress() }
        }
    }

    override fun onBindLayout(): Int = R.layout.activity_main
    override fun getViewModelClazz(): KClass<LoginModelView> =  LoginModelView::class
    override fun onDataBinding(): ActivityMainBinding = baseView?.let {
        ActivityMainBinding.bind(it)
    }!!
    override fun onBindVariableID(): MutableList<Pair<Int, Any>> {
        return arrayListOf(BR.vm to vm)
    }

    override fun initObservable() {}
}