package io.github.gulevsky.palette.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import io.github.gulevsky.palette.R

class PaletteItemView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    var color: Int = 0xFFFFFFFF.toInt()
        set(value) {
            field = value
            colorView.backgroundTintList = ColorStateList.valueOf(value)
        }

    var name: CharSequence?
        get() = nameView.text
        set(value) {
            nameView.text = value
        }

    private val colorView: View
    private val nameView: TextView

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.layout_palette_item, this, true)
        colorView = findViewById(R.id.color_view)
        nameView = findViewById(R.id.name_view)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val overriddenHeightMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, overriddenHeightMeasureSpec)
    }
}
