package com.example.demorestapi

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demorestapi.network.Dog
import com.example.demorestapi.ui.main.DogApiStatus
import com.example.demorestapi.ui.main.DogListAdapter

/**
 * Updates the data shown in the RecyclerView
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Dog>?) {
    val adapter = recyclerView.adapter as DogListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: DogApiStatus?) {
    when (status) {
        DogApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DogApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        DogApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {
            Log.e("BindingAdapters", "Something went wrong")
        }
    }
}
