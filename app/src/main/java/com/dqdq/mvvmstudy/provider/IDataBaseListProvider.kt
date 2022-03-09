package com.dqdq.mvvmstudy.provider

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider

interface IDataBaseListProvider:IProvider {
    val dataBaseFragment:Fragment
}