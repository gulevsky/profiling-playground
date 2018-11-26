package io.github.gulevsky.analytics

import android.util.Log
import io.github.gulevsky.core.perf.Operations.complexOperation

class LogReporter : Reporter {

    init {
        complexOperation(8, 4, 8)
    }

    override fun reportEvent(message: String) {
        Log.i(TAG, message)
    }

    override fun reportError(error: Throwable) {
        Log.e(TAG, error.toString())
    }

    companion object {
        private const val TAG = "Analytics"
    }
}
