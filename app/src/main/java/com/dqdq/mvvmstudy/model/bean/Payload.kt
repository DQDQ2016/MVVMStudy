package com.dqdq.mvvmstudy.model.bean

import com.google.gson.JsonArray

data class Payload(var push_id: Long
                    ,var size: Int
                    ,var distinct_size: String
                    ,var ref: String
                    ,var head: String
                    ,var before: String
                    ,var commits: JsonArray)
