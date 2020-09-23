package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * description：
 * @author 侯程月
 * @date 2020/9/23
 */
class GameViewMoudel : ViewModel() {
    init {
        Log.i("GameViewMoudel", "GameViewMoudel created!! ")
        resetList()

    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewMoudel", "GameViewMoudel destroyed! ")
    }

    //    当前单词
    var word = ""

    //    当前分数
    var score = 0
    private lateinit var wordList: MutableList<String>

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }

    }


    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }
    /**
     * 重新设置数据
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        /**
         * 随机打乱排序
         */
        wordList.shuffle()
    }


}