@file:Suppress("NOTHING_TO_INLINE")

package io.github.gulevsky.palette.utils

import android.content.Context
import android.widget.Toast

inline fun Context.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}
