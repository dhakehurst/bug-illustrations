package test

import kotlin.js.JsExport
import kotlin.jvm.JvmInline


@JvmInline
value class ValueKlass(val vlaue:String)

interface KInterface {
    val vcValue: ValueKlass
}


internal abstract class KlassAbstract : KInterface {

    override var vcValue: ValueKlass = ValueKlass("<unset>")

}


internal class Klass : KlassAbstract() {

}

internal class OtherKlass {
    fun <TR : KlassAbstract>  doIt () {
        val ko: KlassAbstract =  constructIt()
        ko.vcValue = ValueKlass("vc1")
    }

    fun constructIt(): KlassAbstract {
        return Klass()
    }
}