package com.dqdq.mvvmstudy.di

import javax.inject.Inject

/**
 * Created by DQDQ on 15/3/2022
 */
class TestRepository @Inject constructor(
    private val userLocalDataSource:UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
    ) {

    fun load(): String = "${userLocalDataSource.load()} - ${userRemoteDataSource.load()}"
}