package com.dqdq.mvvmstudy.view.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.dqdq.mvvmstudy.model.bean.Event

/**
 * Created by DQDQ on 14/3/2022
 */
abstract class BaseAdapter <T,VH:BaseViewHolder>(layoutResId: Int) :
    BaseQuickAdapter<T, VH>(layoutResId) {

}