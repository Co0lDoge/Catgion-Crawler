package com.example.catgioncrawler.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.catgioncrawler.R
import com.example.catgioncrawler.data.EnemySource
import com.example.catgioncrawler.databinding.FragmentBattleBinding
import com.example.catgioncrawler.model.CatViewModel
import com.example.catgioncrawler.model.EnemyViewModel

class BattleFragment : Fragment() {

    // Binding to interact with view objects
    private var _binding: FragmentBattleBinding? = null
    private val binding get() = _binding!!

    // Shared cat ViewModel
    private val catModel: CatViewModel by activityViewModels()

    private val enemyModel: EnemyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBattleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataset = EnemySource()
        binding

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            catFragment = this@BattleFragment

            catViewModel = catModel
            enemyViewModel = enemyModel

        }

        // Setup enemy with properties
        binding.enemyViewModel?.setupEnemy()

        // TODO: Maybe it would be better to move this to function
        binding.catImage.setImageResource(R.drawable.red_cat)
        binding.imageViewEnemy.setImageResource(R.drawable.blue_cat)

        binding.hitButton.setOnClickListener() {
            catModel.hitEnemy(enemyModel, damage = 1)
        }

        // Changes enemy picture on death
        binding.enemyViewModel?.healthPoints?.observe(viewLifecycleOwner) {
            if (enemyModel.healthPoints.value!! <= 0)
                binding.imageViewEnemy.setImageResource(R.drawable.dead_actor)
        }
    }
}