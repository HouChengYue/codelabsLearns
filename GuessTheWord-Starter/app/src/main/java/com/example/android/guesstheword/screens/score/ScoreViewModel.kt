package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * description：分数记录ViewModel
 * @author 侯程月
 * @date 2020/9/23
 */
class ScoreViewModel(finalScore: Int) : ViewModel() {


    /**
     * 得分
     */
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    /**
     * 点击事件
     */
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }

    fun onPlayAgain() {
        _eventPlayAgain.value=true
    }

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore
    }

}