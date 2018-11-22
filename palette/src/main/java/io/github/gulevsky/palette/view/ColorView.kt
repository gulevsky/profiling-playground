package io.github.gulevsky.palette.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import io.github.gulevsky.core.perf.complexOperation
import io.github.gulevsky.palette.model.Color

class ColorView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        complexOperation(4, 8, action = { Color(0xFF000000.toInt(), "Black") })
    }
}
