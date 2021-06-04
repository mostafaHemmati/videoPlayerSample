package com.hemmati.namavatest

import android.app.Application
import com.hemmati.namavatest.di.NetworkModule
import com.hemmati.namavatest.di.VideosDetailModule
import com.hemmati.namavatest.di.VideosListModule
import com.hemmati.namavatest.di.VideosUrlModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(getModulesList())
        }
    }

    private fun getModulesList(): List<Module> {

        return listOf(NetworkModule, VideosListModule, VideosDetailModule, VideosUrlModule)
    }
}