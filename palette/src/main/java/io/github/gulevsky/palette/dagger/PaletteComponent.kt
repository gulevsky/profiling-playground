package io.github.gulevsky.palette.dagger

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import io.github.gulevsky.analytics.Reporter
import io.github.gulevsky.palette.perfmon.PaletteStartupMonitor
import io.github.gulevsky.palette.view.PaletteViewController

@PaletteScope
@Subcomponent(modules = [PaletteModule::class])
interface PaletteComponent {

    val viewController: PaletteViewController

    val reporter: Reporter

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        @BindsInstance
        fun startupMonitor(monitor: PaletteStartupMonitor): Builder

        fun build(): PaletteComponent
    }
}
