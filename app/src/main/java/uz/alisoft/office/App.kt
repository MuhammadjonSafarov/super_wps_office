package uz.alisoft.office
import android.app.Application

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: App
 * Author: Victor
 * Date: 2023/10/16 17:26
 * Description: 
 * -----------------------------------------------------------------
 */

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        /*if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        else
            Timber.plant(CrashReportingTree())*/
    }
}