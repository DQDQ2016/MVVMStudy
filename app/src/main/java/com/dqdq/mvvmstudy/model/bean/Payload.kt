package com.dqdq.mvvmstudy.model.bean

import com.google.gson.JsonArray
/**
 * Created by DQDQ on 10/3/2022
 */
data class Payload(var push_id: Long
                    ,var size: Int
                    ,var distinct_size: String
                    ,var ref: String
                    ,var head: String
                    ,var before: String
                    ,var commits: JsonArray)
