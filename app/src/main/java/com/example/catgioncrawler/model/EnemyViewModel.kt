package com.example.catgioncrawler.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnemyViewModel : ViewModel() {

    //Properties for enemy
    private val _maxHealthPoints = MutableLiveData<Int>(10)
    private val _maxAbilityPoints = MutableLiveData<Int>(10)

    private var _healthPoints = MutableLiveData<Int>()
    val healthPoints: LiveData<Int> get() = _healthPoints

    private var _abilityPoints = MutableLiveData<Int>()
    val abilityPoints: LiveData<Int> get() = _abilityPoints

    // setup cat properties after program launch
    // TODO: Try to save and load data
    fun setupEnemy() {
        _healthPoints.value = _maxHealthPoints.value?.div(2)
        _abilityPoints.value = _maxAbilityPoints.value?.div(2)
    }

    fun takeDamage(damage: Int) {
        if (_healthPoints.value!! < _maxHealthPoints.value!!)
            _healthPoints.value = _healthPoints.value?.minus(damage)
    }
}