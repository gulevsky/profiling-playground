package io.github.gulevsky.palette.view

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.gulevsky.core.perf.Operations.complexOperation
import io.github.gulevsky.palette.R
import io.github.gulevsky.palette.dagger.PaletteScope
import javax.inject.Inject

@PaletteScope
class PaletteViewController @Inject internal constructor(
        context: Context,
        paletteAdapter: PaletteAdapter
) {

    val recyclerView: RecyclerView

    init {
        val inflater = LayoutInflater.from(context)
        recyclerView = inflater.inflate(R.layout.layout_palette, null) as RecyclerView

        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = paletteAdapter
        }

        complexOperation(2, 4, 2, 4, 2, 4)
    }

    fun onStart() = complexOperation(4, 2, 1, 4, 2, 1, delayMs = 4L)
}
