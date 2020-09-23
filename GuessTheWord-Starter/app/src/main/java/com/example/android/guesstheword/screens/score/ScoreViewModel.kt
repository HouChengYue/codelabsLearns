package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.log

/**
 * description：分数记录ViewModel
 * @author 侯程月
 * @date 2020/9/23
 */
class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score=finalScore
    init {
        Log.i("ScoreViewModel",  "Final score is $finalScore")
    }
}