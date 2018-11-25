package io.github.gulevsky.palette

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
import androidx.core.view.plusAssign
import io.github.gulevsky.palette.dagger.PaletteComponent
import io.github.gulevsky.palette.perfmon.PaletteStartupMonitor
import io.github.gulevsky.palette.utils.toast

class PaletteActivity : AppCompatActivity() {

    private val app: PaletteApplication
        get() = application as PaletteApplication

    private val component: PaletteComponent by lazy {
        app.component.createPaletteComponent()
                .activity(this)
                .startupMonitor(startupMonitor)
                .build()
    }

    private val startupMonitor = PaletteStartupMonitor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        val rootView: ViewGroup = findViewById(R.id.root_view)
        rootView += component.viewController.recyclerView

        window.decorView.doOnPreDraw { onPreDraw() }
        component.reporter.reportEvent("palette activity created")
        startupMonitor.onActivityCreated()
    }

    override fun onStart() {
        super.onStart()
        component.viewController.onStart()
        startupMonitor.onActivityStarted()
    }

    override fun onResume() {
        super.onResume()
        startupMonitor.onActivityResumed()
    }

    private fun onPreDraw() {
        startupMonitor.onActivityDrawn()
        toast("Activity drawn in ${startupMonitor.activityStartDuration} ms")
    }
}
