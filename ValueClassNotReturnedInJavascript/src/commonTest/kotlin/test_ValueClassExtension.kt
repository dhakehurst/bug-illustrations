package test

import kotlin.js.JsExport
import kotlin.jvm.JvmInline
import kotlin.test.Test
import kotlin.test.assertEquals

@JsExport
interface MyInterface {
    val value: String
    val asOther: MyOtherInterface
    val asOtherFails: MyOtherInterface
}

@JsExport
interface MyOtherInterface {
    val value: String
}

@JvmInline
value class MyValueClass1A(override val value: String) : MyInterface {
    override val asOther:MyOtherInterface get() = Functions.toOther1(this)
    override val asOtherFails:MyOtherValueClass get() = Functions.toOther1(this)
}

@JvmInline
value class MyOtherValueClass(override val value: String) : MyOtherInterface {
}

object Functions {
    fun toOther1(myInterface: MyInterface)= MyOtherValueClass(myInterface.value+"A")
}

@JsExport
fun convert(myInterface: MyInterface, isA:Boolean): MyOtherInterface {
    println(myInterface.asOther::class.simpleName)
    return  myInterface.asOther as MyOtherInterface
}


@JsExport
fun convertFails(myInterface: MyInterface, isA:Boolean): MyOtherInterface {
    println(myInterface.asOtherFails::class.simpleName)
    return  myInterface.asOtherFails as MyOtherInterface
}

class test_ValueClassReturnedFromFunction {

    @Test
    fun passes() {
        val v = convert(MyValueClass1A("hello"), true)
        assertEquals("helloA", v.value)
    }

    @Test
    fun failsOnJs() {
        val v = convertFails(MyValueClass1A("hello"), true)
        assertEquals("helloA", v.value)
    }

}