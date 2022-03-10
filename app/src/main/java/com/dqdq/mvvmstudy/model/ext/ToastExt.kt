package com.dqdq.mvvmstudy.model.utils

import android.content.Context
import android.widget.Toast
/**
 * Created by DQDQ on 7/3/2022
 */
@JvmOverloads
fun String.makeToast(c: Context, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(c, this, duration).show()
