package com.dqdq.mvvmstudy.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.trello.rxlifecycle2.components.RxFragment

class BaseFragment: com.trello.rxlifecycle2.components.support.RxFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}