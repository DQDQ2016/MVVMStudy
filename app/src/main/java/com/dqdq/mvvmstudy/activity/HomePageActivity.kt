package com.dqdq.mvvmstudy.activity

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.base.BaseActivity
import com.dqdq.mvvmstudy.constant.ARouterUrlConstant
import com.dqdq.mvvmstudy.fragment.DataBaseFragment
import com.dqdq.mvvmstudy.fragment.NetListFragment
import com.dqdq.mvvmstudy.provider.IDataBaseListProvider
import com.dqdq.mvvmstudy.provider.INetListProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by DQDQ on 9/3/2022
 */
class HomePageActivity : BaseActivity() {

    var dataFragment: Fragment? = null
    var netListFragment: Fragment? = null
    var currentFragment: Fragment? = null

    override fun initView() {
        super.initView()
        if (currentFragment == null){
            if (netListFragment == null)
                netListFragment = NetListFragment.newInstance()
            if (dataFragment == null)
                dataFragment = DataBaseFragment.newInstance()
            currentFragment = netListFragment

            currentFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_content,currentFragment as Fragment
                        ,ARouterUrlConstant.HomePage.DATABASE)
                    .commit()
            }
        }
    }

    override fun initListener() {
        super.initListener()
        findViewById<BottomNavigationView>(R.id.navigation_bottom).setOnItemSelectedListener{
            when(it.itemId){
                R.id.navigation_database_list -> {
                    switchContent(currentFragment,dataFragment,ARouterUrlConstant.HomePage.DATABASE)
                    currentFragment = dataFragment
                }
                R.id.navigation_net_list -> {
                    switchContent(currentFragment,netListFragment,ARouterUrlConstant.HomePage.NET)
                    currentFragment = netListFragment
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun switchContent(from: Fragment?,to: Fragment?,tag: String){
        from?: run { return }
        to?: run { return }
        val trans = supportFragmentManager.beginTransaction()
        if (!to.isAdded)
            trans.hide(from).add(R.id.frame_content,to,tag).commit()
        else
            trans.hide(from).show(to).commit()
    }

    override fun onBindLayout(): Int = R.layout.activity_home_page

}