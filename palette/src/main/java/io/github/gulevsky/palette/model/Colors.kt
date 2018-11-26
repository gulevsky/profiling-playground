package io.github.gulevsky.palette.model

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import io.github.gulevsky.core.perf.Operations.complexOperation
import io.github.gulevsky.palette.R

fun flatColors(context: Context): List<Color> {
    complexOperation(2, 1, 1, 2, 1, 1, 1, 1, delayMs = 32L)
    return listOf(
            Color(context.color(R.color.wet_asphalt), context.getString(R.string.color_wet_asphalt)),
            Color(context.color(R.color.midnight_blue), context.getString(R.string.color_midnight_blue)),
            Color(context.color(R.color.amethyst), context.getString(R.string.color_amethyst)),
            Color(context.color(R.color.wisteria), context.getString(R.string.color_wisteria)),
            Color(context.color(R.color.peter_river), context.getString(R.string.color_peter_river)),
            Color(context.color(R.color.belize_hole), context.getString(R.string.color_belize_hole)),
            Color(context.color(R.color.turquoise), context.getString(R.string.color_turquoise)),
            Color(context.color(R.color.green_sea), context.getString(R.string.color_green_sea)),
            Color(context.color(R.color.emerald), context.getString(R.string.color_emerald)),
            Color(context.color(R.color.nephritis), context.getString(R.string.color_nephritis)),
            Color(context.color(R.color.sun_flower), context.getString(R.string.color_sun_flower)),
            Color(context.color(R.color.orange), context.getString(R.string.color_orange)),
            Color(context.color(R.color.carrot), context.getString(R.string.color_carrot)),
            Color(context.color(R.color.pumpkin), context.getString(R.string.color_pumpkin)),
            Color(context.color(R.color.alizarin), context.getString(R.string.color_alizarin)),
            Color(context.color(R.color.pomegranate), context.getString(R.string.color_pomegranate))
    )
}

private fun Context.color(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)
