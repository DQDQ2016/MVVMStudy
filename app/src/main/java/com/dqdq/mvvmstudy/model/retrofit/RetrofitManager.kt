package com.dqdq.mvvmstudy.model.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
/**
 * Created by DQDQ on 6/3/2022
 */
class RetrofitManager private constructor(){

    private val apiService:ApiService
    private val httpClient:OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        //设置超时
        builder.writeTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.readTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.connectTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)

        httpClient = builder.build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //设置 gson 转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 设置 RxJava2 适配器
            .client(httpClient)
            .build()

        apiService = mRetrofit.create(ApiService::class.java)
    }

    fun retrofit(): Retrofit = mRetrofit

    fun apiService(): ApiService = apiService


    private object Holder{
        val MANAGER = RetrofitManager()
    }

    companion object{
        private lateinit var mRetrofit: Retrofit

        @JvmStatic
        fun get():RetrofitManager{
            return Holder.MANAGER
        }
    }

}