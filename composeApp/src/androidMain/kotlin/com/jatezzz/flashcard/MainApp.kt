package com.jatezzz.flashcard

import android.app.Application
import initKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
