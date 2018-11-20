package io.github.gulevsky.analytics

import android.util.Log

class LogReporter : Reporter {

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
