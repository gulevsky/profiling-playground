@file:JvmName("Operations")

package io.github.gulevsky.core.perf

object Operations {

    fun complexOperation(vararg callCounts: Int, delayMs: Long) {
        complexOperation(callCounts = *callCounts, action = { Thread.sleep(delayMs) })
    }

    fun complexOperation(vararg callCounts: Int, action: () -> Unit = {}) {
        if (callCounts.isEmpty()) {
            action()
            return
        }

        val count = callCounts.first()
        val newCounts = callCounts.sliceArray(1 until callCounts.size)

        for (i in 0 until count) {
            complexOperation(*newCounts, action = action)
        }
    }
}
