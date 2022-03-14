package com.dqdq.mvvmstudy.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.dqdq.mvvmstudy.R
import com.dqdq.mvvmstudy.databinding.NetListItemviewBinding
import com.dqdq.mvvmstudy.model.bean.Event
import com.dqdq.mvvmstudy.model.utils.makeToast

/**
 * Created by DQDQ on 14/3/2022
 */
class NetListAdapter: BaseAdapter<Event,BaseDataBindingHolder<NetListItemviewBinding>>(R.layout.net_list_itemview) {

    override fun convert(holder: BaseDataBindingHolder<NetListItemviewBinding>, item: Event) {
        holder.dataBinding?.apply {
            Glide.with(context).load(item.actor.avatar_url).into(ivUser)
            tvUrl.text = item.actor.url
            tvUsername.text = item.actor.login
            tvActionType.text = item.type

            llItem.setOnClickListener {
                "您点击了:${item.id}".makeToast(context)
            }
        }
    }

}