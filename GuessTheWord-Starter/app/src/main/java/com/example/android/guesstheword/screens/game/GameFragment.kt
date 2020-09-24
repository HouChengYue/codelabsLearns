/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {


    // The list of words - the front of the list is the next word to guess
//    private lateinit var wordList: MutableList<String>

    private lateinit var binding: GameFragmentBinding

    private lateinit var vieeMoudel: GameViewMoudel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        vieeMoudel = ViewModelProvider(this).get(GameViewMoudel::class.java)
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )
        binding.gameViewModel=vieeMoudel
//        resetList()

//        binding.correctButton.setOnClickListener { onCorrect() }
//        binding.skipButton.setOnClickListener { onSkip() }
//        binding.endGameButton.setOnClickListener { onEndGame() }
//        updateScoreText()
//        updateWordText()
//        vieeMoudel.score.observe(viewLifecycleOwner, Observer<Int> {
//            binding.scoreText.text = it.toString()
//        })
//        vieeMoudel.word.observe(viewLifecycleOwner, Observer {
//            binding.wordText.text = it
//        })
        vieeMoudel.eventGameFinish.observe(viewLifecycleOwner, Observer {
            if (it) {gameFinished()}
        })
        vieeMoudel.initDataSetting()
        return binding.root

    }
//
//    /**
//     * 游戏结束
//     */
//    private fun onEndGame() {
//        gameFinished()
//    }

    /**
     * 游戏结束
     */
    private fun gameFinished() {
        findNavController().navigate(GameFragmentDirections.actionGameToScore(
                vieeMoudel.score.value ?: 0))
        Toast.makeText(activity, "游戏结束", Toast.LENGTH_SHORT).show()
        vieeMoudel.onGameFinishComplete()
    }

//    /**
//     * Resets the list of words and randomizes the order
//     */
//    private fun resetList() {
//        wordList = mutableListOf(
//                "queen",
//                "hospital",
//                "basketball",
//                "cat",
//                "change",
//                "snail",
//                "soup",
//                "calendar",
//                "sad",
//                "desk",
//                "guitar",
//                "home",
//                "railway",
//                "zebra",
//                "jelly",
//                "car",
//                "crow",
//                "trade",
//                "bag",
//                "roll",
//                "bubble"
//        )
//        wordList.shuffle()
//    }

    /** Methods for buttons presses **/

//    private fun onSkip() {
////        score--
////        nextWord()
//        vieeMoudel.onSkip()
////        updateWordText()
////        updateScoreText()
//    }

//    private fun onCorrect() {
////        score++
////        nextWord()
//        vieeMoudel.onCorrect()
////        updateWordText()
////        updateScoreText()
//    }

//    /**
//     * Moves to the next word in the list
//     */
//    private fun nextWord() {
//        if (!wordList.isEmpty()) {
//            //Select and remove a word from the list
//            word = wordList.removeAt(0)
//        }
//        updateWordText()
//        updateScoreText()
//    }


    /** Methods for updating the UI **/

//    private fun updateWordText() {
////        binding.wordText.text = word
////        binding.wordText.text = vieeMoudel.word.value
//    }

//    private fun updateScoreText() {
////        binding.scoreText.text = score.toString()
////        binding.scoreText.text = vieeMoudel.score.value.toString()
//    }
}
