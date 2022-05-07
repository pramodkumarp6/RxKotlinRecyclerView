package com.example.threadapp.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.threadapp.model.User


@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, users: List<User>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(users)
}
private fun getOrCreateAdapter(recyclerView: RecyclerView): MainAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is MainAdapter) {
        recyclerView.adapter as MainAdapter
    } else {
        val bindableRecyclerAdapter = MainAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}