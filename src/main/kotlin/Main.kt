import java.io.File
import java.lang.StringBuilder
import java.nio.file.Paths

val PATH = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\"

fun main() {
    val inputText = readFile(PATH + "to_encode.txt")

    val compressed = lzwEncode(inputText)
    writeFile(PATH + "compressed.txt", intToString(compressed))

    val compressedText = readFile(PATH + "compressed.txt")
    val decompressed = lzwDecode(stringToInt(compressedText))
    writeFile(PATH + "decompressed.txt", decompressed)
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
