package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * description：类将负责实例化该ScoreViewModel对象。
 * @author 侯程月
 * @date 2020/9/23
 */
class ScoreViewModelFactory(private val  finalSore:Int) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)){
            return ScoreViewModel(finalSore) as T
        }
        throw IllegalAccessException("Unknow ViewModel class!")
    }
}