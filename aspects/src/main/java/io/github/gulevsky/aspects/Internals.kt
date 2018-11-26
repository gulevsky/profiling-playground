package io.github.gulevsky.aspects

import org.aspectj.lang.Signature

private const val SYSTRACE_SIGNATURE_LIMIT = 127

internal fun Signature.printable(): String {
    val signatureName = this.toShortString()
    return signatureName.substring(0, Math.min(signatureName.length, SYSTRACE_SIGNATURE_LIMIT))
}
