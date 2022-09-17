package com.example.catgioncrawler.data

import com.example.catgioncrawler.R

class EnemySource {

    // Currently returns predetermined list of enemies
    // should return list based of parameters
    fun loadEnemies() : MutableList<Enemy> {
        return mutableListOf(
            Enemy(
                "TestName",
                10,
                10,
                10,
                10,
                R.drawable.blue_cat
            )
        )
    }
}