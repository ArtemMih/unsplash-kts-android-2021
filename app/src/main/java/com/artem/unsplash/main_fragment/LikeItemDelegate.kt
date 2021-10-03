package com.artem.unsplash.main_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.unsplash.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.like_item.view.*

class LikeItemDelegate: AbsListItemAdapterDelegate<Any,Any,LikeItemDelegate.ViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is LikeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.like_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.bind(item as LikeItem)
    }

    inner class ViewHolder(
        override val containerView: View,
        ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private var currentItem: LikeItem? = null


        fun bind(item: LikeItem) = with(containerView) {
            currentItem = item
            like_count.text = item.likeCount.toString()
            thumb_up.setOnClickListener {
                item.likeCount++
                like_count.text = item.likeCount.toString()
            }
        }
    }
}
