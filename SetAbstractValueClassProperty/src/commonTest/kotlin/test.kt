package test

import kotlin.test.Test

class TestCode {

    @Test
    fun test() {

        val obj = OtherKlass()

        obj.doIt<Klass>()

    }

}