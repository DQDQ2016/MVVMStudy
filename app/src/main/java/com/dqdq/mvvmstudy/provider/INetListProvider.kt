package com.dqdq.mvvmstudy.provider

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.template.IProvider
/**
 * Created by DQDQ on 9/3/2022
 */
interface INetListProvider:IProvider {
    val netListFragment:Fragment
}