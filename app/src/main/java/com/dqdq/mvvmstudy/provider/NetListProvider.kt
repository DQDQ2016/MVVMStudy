package com.dqdq.mvvmstudy.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.dqdq.mvvmstudy.constant.ARouterUrlConstant
import com.dqdq.mvvmstudy.fragment.DataBaseFragment
import com.dqdq.mvvmstudy.fragment.NetListFragment
/**
 * Created by DQDQ on 9/3/2022
 */
@Route(path = ARouterUrlConstant.HomePage.NET,name = "网络数据列表")
class NetListProvider :INetListProvider{
    override val netListFragment: Fragment
        get() = NetListFragment.newInstance()

    override fun init(context: Context?) {
    }

}