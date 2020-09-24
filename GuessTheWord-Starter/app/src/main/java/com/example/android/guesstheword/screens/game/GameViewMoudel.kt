package com.example.android.guesstheword.screens.game

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * description：
 * @author 侯程月
 * @date 2020/9/23
 */
class GameViewMoudel : ViewModel() {


    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewMoudel", "GameViewMoudel destroyed! ")
    }

    //    当前单词
    private val _word = MutableLiveData("")
    val word: LiveData<String>
        get() = _word

    //    当前分数
    private val _score = MutableLiveData<Int>(-1)
    val score: LiveData<Int>
        get() = _score

    /**
     * 游戏结束事件
     */
    private val _eventGameFinish = MutableLiveData<Boolean>(false)
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish


    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }


    private lateinit var wordList: MutableList<String>

    private fun nextWord() {
        if (wordList.isNotEmpty()) {
            _word.value = wordList.removeAt(0)
        } else {
            onGameFinish()
        }

    }


    fun onSkip() {
//        score--
        _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
//        score++
        _score.value = score.value?.plus(1)
        nextWord()
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    fun initDataSetting() {
        if (TextUtils.isEmpty(_word.value)) {
            nextWord()
        }
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

    init {
        Log.i("GameViewMoudel", "GameViewMoudel created!! ")
        resetList()
        _score.value = 0
        _word.value = ""

    }
}