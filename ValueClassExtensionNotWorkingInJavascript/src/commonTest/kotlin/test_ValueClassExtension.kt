package test

import test.VC.Companion.asVC2companion
import kotlin.test.Test
import kotlin.test.assertNotNull


class test_ValueClassExtension {

    @Test
    fun test() {
        val str = "hello"

        val vc1 = str.asVC2topFun
        assertNotNull(vc1.value)

        val vc2 = str.asVC2companion
        assertNotNull(vc2.value)
    }
}