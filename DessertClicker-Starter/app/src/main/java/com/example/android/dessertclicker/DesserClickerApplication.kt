package com.example.android.dessertclicker

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * description：为了实例化设置的Application
 * @author 侯程月
 * @date 2020/9/23
 */
class DesserClickerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }

    }


}

private class CrashReportingTree : Timber.Tree() {
    @SuppressLint("LogNotTimber")
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority >= Log.WARN) {
            Log.e(tag, "log: +++${message}", t)
        }
    }
}

