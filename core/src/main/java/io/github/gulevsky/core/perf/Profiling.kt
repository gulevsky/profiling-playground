@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package io.github.gulevsky.core.perf

import android.os.SystemClock
import io.github.gulevsky.core.perf.Profiling.timeMillis
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object Profiling {

    fun timeMillis(): Long = SystemClock.elapsedRealtime()

    fun timeNanos(): Long = SystemClock.elapsedRealtimeNanos()
}

inline fun profile(action: () -> Unit): Long {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    val start = timeMillis()
    action()
    return timeMillis() - start
}
