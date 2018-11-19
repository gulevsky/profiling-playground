package io.github.gulevsky.palette

import android.app.Application
import io.github.gulevsky.palette.dagger.AppComponent
import io.github.gulevsky.palette.dagger.DaggerAppComponent

class PaletteApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
