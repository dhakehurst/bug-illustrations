import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import js.iterable.asFlow
import js.objects.unsafeJso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import web.experimental.ExperimentalWebApi
import web.fs.FileSystemDirectoryHandle
import web.fs.FileSystemPermissionMode
import web.fs.read
import web.fs.showDirectoryPicker

@OptIn(ExperimentalComposeUiApi::class, ExperimentalWebApi::class)
fun main() {
    ComposeViewport {
        val scope = rememberCoroutineScope()
        var openedDir by remember { mutableStateOf<String?>(null) }
        var entries by remember { mutableStateOf<List<String>>(emptyList()) }
        Surface {
            Column {
                Button(onClick = {
                    scope.launch {
                        val handle = showDirectoryPicker(unsafeJso { mode = FileSystemPermissionMode.read })
                        openedDir = handle.name
                        entries = handle.values().asFlow().toList().map { it.name }
                    }
                }) {
                    Text("Open")
                }
                openedDir?.let {
                    Row {
                        Text("Opened Directory: ")
                        Text(it)
                    }
                    Row {
                        Text("Directory Entries: ")
                        Text(entries.joinToString())
                    }
                }
            }
        }
    }
}