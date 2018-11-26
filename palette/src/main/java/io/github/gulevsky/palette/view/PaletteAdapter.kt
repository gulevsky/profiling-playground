package io.github.gulevsky.palette.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.gulevsky.core.perf.Operations.complexOperation
import io.github.gulevsky.palette.dagger.PaletteScope
import io.github.gulevsky.palette.model.Color
import javax.inject.Inject

@PaletteScope
class PaletteAdapter @Inject internal constructor(
        private val items: List<Color>
) : RecyclerView.Adapter<PaletteAdapter.PaletteItemHolder>() {

    init {
        complexOperation(4, 1, 8, 1, 4, 1, delayMs = 4L)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaletteItemHolder {
        complexOperation(8, 4, 2, 1)
        return PaletteItemHolder(PaletteItemView(parent.context))
    }

    override fun onBindViewHolder(holder: PaletteItemHolder, position: Int) = holder.bind(items[position])

    class PaletteItemHolder(private val view: PaletteItemView) : RecyclerView.ViewHolder(view) {

        fun bind(item: Color) {
            view.apply {
                color = item.value
                name = item.name
            }
        }
    }
}
