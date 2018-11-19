package io.github.gulevsky.palette.dagger

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.gulevsky.palette.model.Color
import io.github.gulevsky.palette.model.flatColors

@Module
abstract class PaletteModule {

    @PaletteScope
    @Binds
    abstract fun provideContext(activity: AppCompatActivity): Context

    @Module
    companion object {

        @PaletteScope
        @Provides
        @JvmStatic
        fun provideColorList(context: Context): List<Color> = flatColors(context)
    }
}
