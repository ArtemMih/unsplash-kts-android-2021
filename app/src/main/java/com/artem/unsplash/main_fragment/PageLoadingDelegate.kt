package com.artem.unsplash.main_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artem.unsplash.databinding.LoadingItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class PageLoadingDelegate :
    AbsListItemAdapterDelegate<LoadingItem, Any, PageLoadingDelegate.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val binding = LoadingItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is LoadingItem
    }

    override fun onBindViewHolder(
        item: LoadingItem,
        holder: Holder,
        payloads: MutableList<Any>
    ) {
    }

    class Holder(
        binding: LoadingItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
