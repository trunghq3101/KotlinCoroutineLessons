package com.miller.coroutinesample

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import timber.log.Timber


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        stopKoin()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    viewModelModule
                )
            )
        }
    }
}
