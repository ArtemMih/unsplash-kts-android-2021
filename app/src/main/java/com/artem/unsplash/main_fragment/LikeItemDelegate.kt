package com.artem.unsplash.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.unsplash.databinding.LikeItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class LikeItemDelegate : AbsListItemAdapterDelegate<Any, Any, LikeItemDelegate.ViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is LikeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val binding = LikeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.bind(item as LikeItem)
    }

    inner class ViewHolder(
        private val binding: LikeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LikeItem) = with(binding) {
            likeCount.text = item.likeCount.toString()
            thumbUp.setOnClickListener {
                item.likeCount++
                likeCount.text = item.likeCount.toString()
            }
        }
    }
}
