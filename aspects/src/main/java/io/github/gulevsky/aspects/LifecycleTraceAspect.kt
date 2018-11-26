@file:Suppress("unused")

package io.github.gulevsky.aspects

import android.os.Trace
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

@Aspect
class LifecycleTraceAspect {

    @Pointcut("within(android.app.Application+) && execution(* onCreate(..))")
    fun application() = Unit

    @Pointcut("within(android.app.Activity+) && " +
            "(execution(* onCreate(..)) || execution(* onStart(..)) || execution(* onResume(..)))")
    fun activity() = Unit

    @Pointcut("within(android.view.View+) && " +
            "(execution(new(..)) || execution(* onMeasure(..)) || execution(* onLayout(..)) || execution(* onDraw(..)))")
    fun view() = Unit

    @Pointcut("within(io.github.gulevsky.aspects..*)")
    fun excluded() = Unit

    @Before("(application() || activity() || view()) && !excluded()")
    fun doBeforeMethod(joinPoint: JoinPoint) {
        Trace.beginSection(joinPoint.signature.printable())
    }

    @AfterReturning("(application() || activity() || view()) && !excluded()")
    fun doAfterMethod(joinPoint: JoinPoint) {
        Trace.endSection()
    }
}
