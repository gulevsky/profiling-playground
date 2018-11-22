package io.github.gulevsky.palette

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.plusAssign
import io.github.gulevsky.palette.dagger.PaletteComponent

class PaletteActivity : AppCompatActivity() {

    private val app: PaletteApplication
        get() = application as PaletteApplication

    private val component: PaletteComponent by lazy {
        app.component.createPaletteComponent()
                .activity(this)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette)

        val rootView: ViewGroup = findViewById(R.id.root_view)
        rootView += component.viewController.recyclerView

        component.reporter.reportEvent("palette activity created")
    }

    override fun onStart() {
        super.onStart()
        component.viewController.onStart()
    }
}
