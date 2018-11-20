package io.github.gulevsky.palette.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.github.gulevsky.analytics.Reporter
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val application: Application

    fun createPaletteComponent(): PaletteComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun reporter(reporter: Reporter): Builder

        fun build(): AppComponent
    }
}
