package com.example.demorestapi.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.demorestapi.R
import com.example.demorestapi.databinding.FragmentDogListBinding

class DogListFragment : Fragment() {
    private val viewModel: DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDogListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.getDogList()
        binding.recyclerView.adapter = DogListAdapter(DogListener { dog ->
            viewModel.onDogClicked(dog)
            findNavController()
                .navigate(R.id.action_dogListFragment_to_dogDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}