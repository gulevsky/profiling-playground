package io.github.gulevsky.palette

import android.app.Application
import io.github.gulevsky.analytics.Analytics
import io.github.gulevsky.analytics.Reporter
import io.github.gulevsky.palette.dagger.AppComponent
import io.github.gulevsky.palette.dagger.DaggerAppComponent
import java.util.*

class PaletteApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .reporter(reporter)
                .build()
    }

    private lateinit var reporter: Reporter

    override fun onCreate() {
        super.onCreate()

        Analytics.initialize(this)
        reporter = Analytics.getReporter(ANALYTICS_KEY)
    }

    companion object {
        private val ANALYTICS_KEY = UUID.randomUUID().toString()
    }
}
