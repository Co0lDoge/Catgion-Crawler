package com.example.catgioncrawler.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CatViewModel: ViewModel() {

    //Properties for cat
    private val _maxHealthPoints = MutableLiveData<Int>(10)
    private val _maxAbilityPoints = MutableLiveData<Int>(10)

    private var _healthPoints = MutableLiveData<Int>()
    val healthPoints: LiveData<Int> = _healthPoints

    private var _abilityPoints = MutableLiveData<Int>()
    val abilityPoints: LiveData<Int> = _abilityPoints

    // setup cat properties after program launch
    // TODO: Try to save and load data
    fun setupCat() {
        _healthPoints.value = _maxHealthPoints.value?.div(2)
        _abilityPoints.value = _maxAbilityPoints.value?.div(2)
    }

    // This function should be remade to make possible to choose enemy
    fun hitEnemy(enemyViewModel: EnemyViewModel, damage: Int) {
        enemyViewModel.takeDamage(damage)
    }

    // Fix Listener bindings
    fun healCat() {
        if (_healthPoints.value!! < _maxHealthPoints.value!!)
            _healthPoints.value = _healthPoints.value?.plus(1)
    }
}