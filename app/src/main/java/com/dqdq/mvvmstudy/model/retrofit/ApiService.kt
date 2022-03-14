package com.dqdq.mvvmstudy.model.retrofit

import com.dqdq.mvvmstudy.model.bean.Event
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import retrofit2.http.Path
/**
 * Created by DQDQ on 7/3/2022
 */
interface ApiService{

    companion object{
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users/{username}/events/public")
    fun publicEvent(@Path("username") username:String): Observable<MutableList<Event>>

}