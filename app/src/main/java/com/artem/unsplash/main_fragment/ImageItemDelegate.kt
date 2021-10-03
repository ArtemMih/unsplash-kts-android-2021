package com.artem.unsplash.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.unsplash.databinding.ImageItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ImageItemDelegate : AbsListItemAdapterDelegate<Any, Any, ImageItemDelegate.ViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is ImageItem
    }

    override fun onCreateViewHolder(parent: ViewGroup): ImageItemDelegate.ViewHolder {
        val binding = ImageItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(item: Any, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.bind(item as ImageItem)
    }

    inner class ViewHolder(
        private val binding: ImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: ImageItem? = null

        fun bind(item: ImageItem) = with(binding) {
            currentItem = item
            author.text = item.author
        }
    }
}