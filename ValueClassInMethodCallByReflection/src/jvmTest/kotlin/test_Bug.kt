package test

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.jvm.kotlinFunction
import kotlin.test.Test

@JvmInline
value class VC(val value:String)

interface FuncInterface {
    fun func(vc:VC):String
}

class Destination : FuncInterface {
    override fun func(vc: VC):String {
        println(vc.value)
        return "done"
    }
}

fun <T : Any> proxyFor(forInterface: KClass<*>, invokeMethod: (handler: Any, proxy: Any?, callable: KCallable<*>, methodName: String, args: Array<out Any>) -> Any?): T {
    val handler = object : InvocationHandler {
        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
            val args2 = args ?: emptyArray<Any>()
            val callable = method?.kotlinFunction!!
            // method.name gives a mangled name !
            return invokeMethod.invoke(this, proxy, callable, callable.name, args2)
        }
    }
    val proxy = Proxy.newProxyInstance(forInterface.java.classLoader, arrayOf(forInterface.java), handler)
    return proxy as T
}

class test_Bug {

    @Test
    fun test() {
        val dest = Destination()
        val proxy:FuncInterface = proxyFor(FuncInterface::class) { handler, prosy, callable, methodName, args ->
            val meth = dest::class.members.first { it.name == methodName }
            meth.call(args)
        }

        val vc = VC("vc")
        proxy.func(vc)
    }
}