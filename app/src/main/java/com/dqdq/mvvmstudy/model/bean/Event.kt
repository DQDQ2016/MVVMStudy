package com.dqdq.mvvmstudy.model.bean
/**
 * Created by DQDQ on 10/3/2022
 */
data class Event(var id:String
                 ,var type:String
                 ,var actor: Actor
                 ,var payload: Payload
                 ,var public: Boolean
                 ,var created_at: String)
