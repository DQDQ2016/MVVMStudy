package com.dqdq.mvvmstudy.minterface

import androidx.viewbinding.ViewBinding
/**
 * Created by DQDQ on 10/3/2022
 */
interface IActivityDataBinding<t:ViewBinding>:IDataBindingHolder<t> {

    fun inflate(b:()->t)

}