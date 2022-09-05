package com.example.catgioncrawler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.catgioncrawler.databinding.FragmentCatBinding
import com.example.catgioncrawler.model.CatViewModel

class CatFragment : Fragment() {

    // Binding object correspond to the cat_fragment xml file,
    // instantiating the contents of layout XML files
    // into their corresponding View objects
    private var _binding: FragmentCatBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: CatViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCatBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            // Shared model for cat
            viewModel = sharedViewModel
            catFragment = this@CatFragment
        }


        // Setup cat with properties
        binding.viewModel?.setupCat()

        // TODO: Maybe it would be better to move this to function
        binding.imageViewCat.setImageResource(R.drawable.red_cat)

        // Set listener for first button
        binding.actionOne.setOnClickListener { binding.viewModel?.healCat() }
    }

    fun gotoMap() {
        findNavController().navigate(R.id.action_catFragment_to_battleFragment)
    }
}