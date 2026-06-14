@file:OptIn(ExperimentalJsExport::class)

package bug

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
class AClass

@JsExport
class AClass2(val x:Int)

@JsExport
interface MyInterface {
    val value:Int
}