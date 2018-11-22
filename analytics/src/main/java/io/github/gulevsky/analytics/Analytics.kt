package io.github.gulevsky.analytics

import android.content.Context
import io.github.gulevsky.core.perf.complexOperation

object Analytics {

    private val reporters: Map<String, Reporter> = HashMap()
    private val keyRegex: Regex by lazy {
        "[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}".toRegex(RegexOption.IGNORE_CASE)
    }

    private var initialized = false

    fun initialize(context: Context) {
        synchronized(this) {
            if (!initialized) {
                performInitialization(context)
                initialized = true
            }
        }
    }

    private fun performInitialization(context: Context) = complexOperation(2, 1, 2, 1, 2, 1, 1, 1, delayMs = 64L)

    fun getReporter(key: String): Reporter {
        synchronized(this) {
            if (!initialized) throw IllegalStateException("initialize() should be called first")

            if (!validateKey(key)) throw IllegalArgumentException("invalid key: $key")

            return reporters.getOrElse(key) {
                LogReporter()
            }
        }
    }

    private fun validateKey(key: String) = key.matches(keyRegex)
}
