package com.dqdq.mvvmstudy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dqdq.mvvmstudy.R
/**
 * Created by DQDQ on 9/3/2022
 */
class NetListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_net_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = NetListFragment()

    }
}