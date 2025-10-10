package test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import js.objects.JsPlainObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import web.experimental.ExperimentalWebApi
import web.fs.DirectoryPickerOptions
import web.fs.FileSystemDirectoryHandle
import web.fs.FileSystemPermissionMode
import web.fs.read
import web.fs.showDirectoryPicker
import web.window.window
import kotlin.js.Promise

@OptIn(ExperimentalComposeUiApi::class, ExperimentalWebApi::class)
suspend fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        ComposeViewport {
            val scope = rememberCoroutineScope()
            var openedDir by remember { mutableStateOf<String?>(null) }
            Surface {
                Column {
                    Button(onClick = {
                        scope.launch {
                            val handle = showDirectoryPicker(DirectoryPickerOptions(mode= FileSystemPermissionMode.read))
                            openedDir = handle.name
                        }
                    }) {
                        Text("Open")
                    }
                    openedDir?.let {
                        Row {
                            Text("Opened Directory: ")
                            Text(it)
                        }
                    }
                }
            }
        }
    }.join()
}