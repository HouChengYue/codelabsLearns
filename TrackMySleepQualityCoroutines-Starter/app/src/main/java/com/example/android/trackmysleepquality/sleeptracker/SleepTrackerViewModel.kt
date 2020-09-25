/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality.sleeptracker

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.*
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.formatNights
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
        val database: SleepDatabaseDao,
        application: Application) : AndroidViewModel(application) {
    private var tonight = MutableLiveData<SleepNight?>()
    init {
        initalizeTonight()
    }


    private val nights=database.getAllNights()
    val nightString=Transformations.map(nights){
        nights->
        formatNights(nights,application.resources)
    }

    private fun initalizeTonight() {
        viewModelScope.launch {
            tonight.value=getTonightFromDataBase()
        }
    }

    fun onStartTracking(){
        viewModelScope.launch {
          val newNight = SleepNight()
            insert(newNight)
            tonight.value=getTonightFromDataBase()
        }
    }
    private suspend fun insert(night: SleepNight){
        database.insert(night)
    }


    private suspend fun getTonightFromDataBase(): SleepNight? {
        var  night=database.getTonight()
        if (night?.endTimeMilli!=night?.startTimeMilli){
            night=null
        }
        return night
    }
    fun someWorfNeedsToBeDne(){
        viewModelScope.launch {
            suspendFunction()
        }
    }

    private suspend fun suspendFunction() {
        withContext(Dispatchers.IO){
            longrunningWork()
            suspendDAOFunction()
        }
    }


    fun onStoptracking(){
        viewModelScope.launch {
            val oldNithg=tonight.value?:return@launch
            oldNithg.endTimeMilli=System.currentTimeMillis()
            update(oldNithg)
        }
    }

    private suspend fun update(night: SleepNight){
        database.update(night)
    }

    fun onClear(){
        viewModelScope.launch {
            clear()
            tonight.value=null
        }
    }
    private suspend fun clear(){
        database.clear()
    }

    private suspend fun suspendDAOFunction() {
        longrunningDatabaseWork()
    }

    private fun longrunningDatabaseWork() {

    }

    private fun longrunningWork() {

    }
}

