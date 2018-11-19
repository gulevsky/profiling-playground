package io.github.gulevsky.palette.dagger

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import io.github.gulevsky.palette.view.PaletteViewController

@PaletteScope
@Subcomponent(modules = [PaletteModule::class])
interface PaletteComponent {

    val viewController: PaletteViewController

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): PaletteComponent
    }
}
