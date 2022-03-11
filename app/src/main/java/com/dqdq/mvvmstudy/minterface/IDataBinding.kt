package com.dqdq.mvvmstudy.minterface

import androidx.databinding.ViewDataBinding
/**
 * Created by DQDQ on 10/3/2022
 */
interface IDataBinding<t: ViewDataBinding>:IDataBindingHolder<t> {

    fun inflate(b:()->t)

}