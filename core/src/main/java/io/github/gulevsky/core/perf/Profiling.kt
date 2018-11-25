@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package io.github.gulevsky.core.perf

import android.os.SystemClock
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

inline fun profile(action: () -> Unit): Long {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }

    val start = timeMillis()
    action()
    return timeMillis() - start
}

inline fun timeMillis(): Long = SystemClock.elapsedRealtime()

inline fun timeNanos(): Long = SystemClock.elapsedRealtimeNanos()
