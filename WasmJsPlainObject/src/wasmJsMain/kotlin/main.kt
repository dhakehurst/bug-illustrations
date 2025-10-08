package test

import js.objects.JsPlainObject
import web.fs.FileSystemDirectoryHandle
import kotlin.js.Promise

@JsPlainObject
external interface FilePickerOptions {
    val mode: String
}

external interface WasmWindow {
    fun showDirectoryPicker(options: FilePickerOptions? = definedExternally): Promise<FileSystemDirectoryHandle>
}

suspend fun main() {
    println("Starting WasmJsPlainObject bug illustration")
    val ww = js("window") as WasmWindow
    val handle = ww.showDirectoryPicker(FilePickerOptions("read"))

}