package com.example.android.trackmysleepquality.sleeptracker

import androidx.recyclerview.widget.DiffUtil
import com.example.android.trackmysleepquality.database.SleepNight

/**
 * description：
 * @author 侯程月
 * @date 2020/9/27
 */
class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId==newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem==newItem
    }
}