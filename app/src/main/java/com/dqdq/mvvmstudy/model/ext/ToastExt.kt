package com.dqdq.mvvmstudy.model.utils

import android.content.Context
import android.widget.Toast

@JvmOverloads
fun String.makeToast(c: Context, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(c, this, duration).show()
