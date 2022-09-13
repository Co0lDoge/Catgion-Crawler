package com.example.catgioncrawler.data

import androidx.annotation.DrawableRes

data class Enemy (
    val enemyName: String,
    val maxHealthPoints: Int,
    var healthPoints: Int,
    val maxAbilityPoints: Int,
    var abilityPoints: Int,

    @DrawableRes val drawableResourceId: Int
)