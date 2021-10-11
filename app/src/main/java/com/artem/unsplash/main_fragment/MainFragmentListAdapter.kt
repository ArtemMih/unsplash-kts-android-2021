package com.artem.unsplash.main_fragment

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainFragmentListAdapter : AsyncListDifferDelegationAdapter<Any>(ComplexDiffCallback()) {

    init {
        delegatesManager
            .addDelegate(LikeItemDelegate())
            .addDelegate(ImageItemDelegate())
            .addDelegate(PageLoadingDelegate())
    }

    class ComplexDiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(first: Any, second: Any): Boolean {
            return first.javaClass == second.javaClass && when (first) {
                is LikeItem -> first.uuid == (second as LikeItem).uuid
                is ImageItem -> first.uuid == (second as ImageItem).uuid
                else -> true
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(first: Any, second: Any): Boolean = first == second
    }
}