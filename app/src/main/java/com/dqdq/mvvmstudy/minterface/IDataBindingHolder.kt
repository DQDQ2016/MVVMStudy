package com.dqdq.mvvmstudy.minterface

import androidx.viewbinding.ViewBinding
import java.lang.IllegalStateException

interface IDataBindingHolder<T: ViewBinding> {

    fun requireBinding(): T

    open class BindingHolder<VB: ViewBinding>:IDataBindingHolder<VB>{

        private var binding: VB? = null

        override fun requireBinding(): VB {

            if (binding == null){
                throw IllegalStateException("DataBinding not yet initialized")
            }

            return binding!!
        }

        fun bind(b:VB) {
            binding = b
        }
    }
}