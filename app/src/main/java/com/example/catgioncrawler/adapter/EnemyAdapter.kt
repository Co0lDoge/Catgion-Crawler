package com.example.catgioncrawler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catgioncrawler.R
import com.example.catgioncrawler.data.Enemy
import com.example.catgioncrawler.databinding.ListEnemyBinding

class EnemyAdapter(dataset: MutableList<Enemy>): ListAdapter<Enemy, EnemyAdapter.EnemyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EnemyAdapter.EnemyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class EnemyViewHolder(private val binding: ListEnemyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(enemy: Enemy) {
            binding.apply {

            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Enemy>() {
            override fun areItemsTheSame(oldItem: Enemy, newItem: Enemy): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Enemy, newItem: Enemy): Boolean {
                return oldItem.enemyName == newItem.enemyName
            }

        }
    }

}