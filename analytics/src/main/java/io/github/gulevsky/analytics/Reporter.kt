package io.github.gulevsky.analytics

interface Reporter {

    fun reportEvent(message: String)

    fun reportError(error: Throwable)
}
