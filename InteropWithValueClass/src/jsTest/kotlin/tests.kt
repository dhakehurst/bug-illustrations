package test

import kotlin.test.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun test1() {

        val vc1 = VC1("myvalue")

        val jsValue = js("vc1.value")

         assertEquals(vc1.value, jsValue)
    }

    @Test
    fun test2() {

        val l = listOf(VC2("myvalue"))

        val vc2 = js("l.get(0)")
        val jsValue = js("vc2.value")

        assertEquals(vc2.value, jsValue)
    }

}