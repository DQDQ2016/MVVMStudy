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

class HomePageActivity : BaseActivity() {

    @Autowired(name = ARouterUrlConstant.HomePage.DATABASE)
    @JvmField
    var mDatabaseProvider: IDataBaseListProvider? = null

    @Autowired(name = ARouterUrlConstant.HomePage.NET)
    @JvmField
    var mNetProvider: INetListProvider? = null

    var dataFragment: Fragment? = null
    var netListFragment: Fragment? = null
    var currentFragment: Fragment? = null

    override fun initView() {
        super.initView()
        dataFragment = mDatabaseProvider?.dataBaseFragment
        netListFragment = mNetProvider?.netListFragment

        currentFragment = dataFragment

        currentFragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_content,currentFragment as Fragment
                    ,ARouterUrlConstant.HomePage.DATABASE)
                .commit()
        }
    }

    override fun initListener() {
        super.initListener()
        findViewById<BottomNavigationView>(R.id.navigation_bottom).setOnItemSelectedListener{
            when(it.itemId){
                R.id.navigation_database_list -> switchContent(currentFragment,dataFragment
                    ,ARouterUrlConstant.HomePage.DATABASE).also { currentFragment = dataFragment }
                R.id.navigation_net_list -> switchContent(currentFragment,netListFragment
                ,ARouterUrlConstant.HomePage.NET).also { currentFragment = netListFragment }
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
    }

    override fun enableDataBinding(): Boolean = false

    override fun enableLifecycle(): Boolean = false

    override fun onBindLayout(): Int = R.layout.activity_home_page

}