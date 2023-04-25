package com.example.catgioncrawler.data

import com.example.catgioncrawler.R

class EnemySource {
    // Currently returns predetermined list of enemies
    // should return list based of parameters
    fun loadEnemies() : MutableList<Enemy> {
        return mutableListOf(
            Enemy(
                "Axaris",
                10,
                10,
                10,
                10,
                R.drawable.blue_cat
            ),
            Enemy(
                "Notos",
                10,
                10,
                10,
                10,
                R.drawable.red_cat
            ),
            Enemy(
                "Metunos",
                10,
                10,
                10,
                10,
                R.drawable.red_cat
            )
        )
    }
}