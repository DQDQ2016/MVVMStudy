package com.dqdq.mvvmstudy.di

import javax.inject.Inject

/**
 * Created by DQDQ on 15/3/2022
 */
class UserLocalDataSource @Inject constructor():DataSource {
    override fun load(): String = "UserRemoteDataSource.load()"
}