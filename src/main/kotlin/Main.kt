import java.io.File
import java.nio.file.Paths

val PATH = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\"

fun main() {
//    val inputText = readFile(PATH + "to_encode.txt")
//    writeFile(PATH + "encoded.txt", inputText)

    val compressed = lzwEncode("geekific-geekific")
    println(compressed)
    val decompressed = lzwDecode(compressed.toMutableList())
    println(decompressed)
}

fun readFile(path: String): String = File(path)
    .inputStream()
    .bufferedReader()
    .use {
        it.readText()
    }

fun writeFile(path: String, text: String) {
    File(path).bufferedWriter().use { out ->
        out.write(text)
    }
}
