package test

import kotlin.js.JsExport
import kotlin.jvm.JvmInline

@JvmInline
value class VC1(val value: String)

@JsExport
interface PubValue {
    val value: String
}

@JvmInline
value class VC2(override val value: String) : PubValue