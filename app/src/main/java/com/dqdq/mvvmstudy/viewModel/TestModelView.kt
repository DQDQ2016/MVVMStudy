package com.dqdq.mvvmstudy.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.dqdq.mvvmstudy.base.BaseViewModel
import com.dqdq.mvvmstudy.di.TestRepository
import javax.inject.Inject

/**
 * Created by DQDQ on 15/3/2022
 */
class TestModelView @Inject constructor(private val testRepository: TestRepository) : ViewModel() {
    fun loadData():String = testRepository.load()
}