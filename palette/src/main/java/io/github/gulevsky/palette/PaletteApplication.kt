package io.github.gulevsky.palette

import android.app.Application
import io.github.gulevsky.analytics.Analytics
import io.github.gulevsky.analytics.Reporter
import io.github.gulevsky.palette.dagger.AppComponent
import io.github.gulevsky.palette.dagger.DaggerAppComponent

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
        private const val ANALYTICS_KEY = "879B3811-DD35-4ED1-A50C-02CADD2499D1"
    }
}
