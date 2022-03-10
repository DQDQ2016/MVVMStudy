package com.dqdq.mvvmstudy.provider

import android.content.Context
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.dqdq.mvvmstudy.constant.ARouterUrlConstant
import com.dqdq.mvvmstudy.fragment.DataBaseFragment
/**
 * Created by DQDQ on 9/3/2022
 */
@Route(path = ARouterUrlConstant.HomePage.DATABASE,name = "数据库列表")
class DataBaseListProvider :IDataBaseListProvider{

    override val dataBaseFragment: Fragment
        get() = DataBaseFragment.newInstance()

    override fun init(context: Context?) {
    }

}