@file:Suppress("unused")

package io.github.gulevsky.aspects

import android.os.Trace
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

@Aspect
class TraceAspect {

    @Pointcut("staticinitialization(*)")
    fun statics() = Unit

    @Pointcut("execution(*.new(..))")
    fun constructors() = Unit

    @Pointcut("execution(* *(..))")
    fun methods() = Unit

    @Pointcut("within(io.github.gulevsky.aspects..*)")
    fun excluded() = Unit

    @Before("(statics() || constructors() || methods()) && !excluded()")
    fun doBeforeMethod(joinPoint: JoinPoint) {
        Trace.beginSection(joinPoint.signature.printable())
    }

    @AfterReturning("(statics() || constructors() || methods()) && !excluded()")
    fun doAfterMethod(joinPoint: JoinPoint) {
        Trace.endSection()
    }
}
