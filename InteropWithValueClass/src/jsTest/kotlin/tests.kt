package test

import kotlin.test.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun test1() {
        val jsclass = VC1::class.js
        val vc1 = js("Reflect.construct(jsclass, ['myvalue'])") // VC1("myvalue")
        val jsValue = js("vc1.value")

         assertEquals("myvalue", jsValue)
    }

    @Test
    fun test2() {
        val jsclass = VC2::class.js
        val vc2 = js("Reflect.construct(jsclass, ['myvalue'])") // VC2("myvalue")
        val jsValue = js("vc2.value")

        assertEquals("myvalue", jsValue)
    }

}