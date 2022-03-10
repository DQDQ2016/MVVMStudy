package com.dqdq.mvvmstudy.minterface

import androidx.viewbinding.ViewBinding

interface IActivityDataBinding<t:ViewBinding>:IDataBindingHolder<t> {

    fun inflate(b:()->t)

}