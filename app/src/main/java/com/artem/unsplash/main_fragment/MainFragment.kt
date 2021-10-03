package com.artem.unsplash.main_fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.artem.unsplash.R
import com.artem.unsplash.databinding.MainBinding
import com.artem.unsplash.utils.PaginationScrollListener
import com.artem.unsplash.utils.autoCleared
import java.util.*

class MainFragment : Fragment(R.layout.main) {

    private val binding: MainBinding by viewBinding(MainBinding::bind)
    private var mainAdapter: MainFragmentListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        loadMoreItems()
    }

    private fun initList() {
        mainAdapter = MainFragmentListAdapter()
        with(binding.list) {
            val orientation = RecyclerView.VERTICAL
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context, orientation, false)

            // Pagination
            addOnScrollListener(
                PaginationScrollListener(
                    layoutManager = layoutManager as LinearLayoutManager,
                    requestNextItems = ::loadMoreItems,
                    visibilityThreshold = 0
                )
            )

            addItemDecoration(DividerItemDecoration(context, orientation))
            setHasFixedSize(true)
        }
    }

    private fun getDefaultItems() = List(20) {
        val randomUUID = UUID.randomUUID()
        when ((1..2).random()) {
            1 -> LikeItem(
                uuid = randomUUID,
                likeCount = (0..100).random()
            )
            2 -> ImageItem(
                uuid = randomUUID,
                image = R.drawable.photo_stub.toString(),
                author = "Markus Spiske",
                avatar = R.drawable.ava.toString()

            )
            else -> error("Wrong random number")
        }
    }

    private fun loadMoreItems() {
        val newItems = mainAdapter.items.toMutableList().apply {
            if (lastOrNull() is Int) {
                removeLastOrNull()
            }
        } + getDefaultItems()
        mainAdapter.items = newItems
        Log.d("Pagination", newItems.size.toString())
    }

}