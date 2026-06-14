package test

class Accessor {

    fun getData(): Any {
        // get data simply
        return 1
    }

    suspend fun getDataSuspend(): Any {
        // get data, requiring suspend...i.e. from a network call
        return 1
    }

}

class ComplexFunctions (
    val accessor: Accessor
) {

    fun nonSuspendFun() {
        // do something complex I want to reuse involving accessor
        accessor.getData()
    }

    suspend fun suspendFun() {
        // do something complex I want to reuse involving accessor
        accessor.getDataSuspend()
    }

}