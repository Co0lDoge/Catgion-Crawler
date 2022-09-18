package com.example.catgioncrawler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catgioncrawler.data.Enemy
import com.example.catgioncrawler.databinding.ListEnemyBinding

class EnemyAdapter(private val dataset: MutableList<Enemy>): ListAdapter<Enemy, EnemyAdapter.EnemyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EnemyViewHolder {
        return EnemyViewHolder(
            ListEnemyBinding.inflate(
                LayoutInflater.from(
                    parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        holder.bind(dataset, position)
    }

    class EnemyViewHolder(private val binding: ListEnemyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            dataset: MutableList<Enemy>,
            position: Int
        ) {
            binding.apply {
                enemyImage.setImageResource(dataset[position].drawableResourceId)
                enemyName.text = (dataset[position].enemyName)
            }
        }
    }

    override fun getItemCount() = dataset.size

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