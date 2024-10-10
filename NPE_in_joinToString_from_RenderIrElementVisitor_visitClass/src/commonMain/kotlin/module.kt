package test

import kotlin.js.JsExport


fun createA() : A = AImpl()

interface A {
    var prop : Int
    var x : String
}
@JsExport
abstract class AAbstract : A {
    override var prop: Int
        get() = 1
        set(value) {}
}
@JsExport
class AImpl : AAbstract() {
    override var x: String
        get() = "x"
        set(value) {}
}