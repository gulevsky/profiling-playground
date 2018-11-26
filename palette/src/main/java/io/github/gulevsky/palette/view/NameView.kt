package io.github.gulevsky.palette.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import io.github.gulevsky.core.perf.Operations.complexOperation

class NameView(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    init {
        complexOperation(1, 1, 1, 1, 2, delayMs = 8L)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        complexOperation(1, 1, 1, 1, delayMs = 4L)
        invalidate()
    }
}
