package com.example.demorestapi.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demorestapi.databinding.ListViewItemBinding
import com.example.demorestapi.network.Dog

class DogListAdapter(private val clickListener: DogListener) :
    ListAdapter<Dog, DogListAdapter.DogViewHolder>(DiffCallback) {

    class DogViewHolder(
        private var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: DogListener, dog: Dog) {
            binding.dog = dog
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Dog>() {

        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.weight == newItem.weight && oldItem.foodAmount == newItem.foodAmount
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        holder.bind(clickListener, dog)
    }
}

class DogListener(val clickListener: (dog: Dog) -> Unit) {
    fun onClick(dog: Dog) = clickListener(dog)
}
