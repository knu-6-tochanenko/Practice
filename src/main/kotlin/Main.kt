import java.io.File
import java.lang.StringBuilder
import java.nio.file.Paths

val PATH = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\"

fun main(args: Array<String>) {
    runLzw(args[0])
}


fun runLzw(file: String) {
    val inputText = readFile("$PATH$file.txt")

    val compressed = lzwEncode(inputText)
    writeFile("$PATH${file}_compressed.txt", intToString(compressed))

    val compressedText = readFile("$PATH${file}_compressed.txt")
    val decompressed = lzwDecode(stringToInt(compressedText))
    writeFile("$PATH${file}_decompressed.txt", decompressed)
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

fun intToString(intList: List<Int>): String {
    val res = StringBuilder("")
    for (i in intList) {
        res.append(i.toChar())
    }
    return res.toString()
}

fun stringToInt(str: String): MutableList<Int> {
    val res = mutableListOf<Int>()
    for (i in str) {
        res.add(i.code)
    }
    return res
}
