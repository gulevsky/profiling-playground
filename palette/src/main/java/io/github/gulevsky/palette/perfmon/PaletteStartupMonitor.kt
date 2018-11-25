package io.github.gulevsky.palette.perfmon

import io.github.gulevsky.core.perf.timeMillis
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PaletteStartupMonitor {

    var applicationCreateDuration: Long by Metrics()
        private set

    var activityCreateDuration: Long by Metrics()
        private set

    var activityStartDuration: Long by Metrics()
        private set

    var activityResumeDuration: Long by Metrics()
        private set

    var activityDrawDuration: Long by Metrics()
        private set

    private val initTime: Long = timeMillis()

    fun onApplicationCreated() {
        applicationCreateDuration = timeMillis() - initTime
    }

    fun onActivityCreated() {
        activityCreateDuration = timeMillis() - initTime
    }

    fun onActivityStarted() {
        activityStartDuration = timeMillis() - initTime
    }

    fun onActivityResumed() {
        activityResumeDuration = timeMillis() - initTime
    }

    fun onActivityDrawn() {
        activityDrawDuration = timeMillis() - initTime
    }
}

private class Metrics : ReadWriteProperty<PaletteStartupMonitor, Long>{

    private var _value: Long = UNINITIALIZED_VALUE
    override fun getValue(thisRef: PaletteStartupMonitor, property: KProperty<*>): Long = _value

    override fun setValue(thisRef: PaletteStartupMonitor, property: KProperty<*>, value: Long) {
        if (_value == UNINITIALIZED_VALUE && value >= 0L) {
            _value = value
        }
    }

    companion object {
        private const val UNINITIALIZED_VALUE = -1L
    }
}
