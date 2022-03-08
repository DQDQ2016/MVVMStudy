package com.dqdq.mvvmstudy.model.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.widget.ImageView
import com.dqdq.mvvmstudy.R

object DialogUtils {

    @SuppressLint("ResourceType")
    open fun getLoadingDialog(c: Context):Dialog{
        var d = Dialog(c)
        d.setContentView(R.layout.dialog_loading)
        d.setCancelable(false)
        return d
    }
}