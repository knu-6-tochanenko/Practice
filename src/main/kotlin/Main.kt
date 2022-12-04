import java.io.File
import java.lang.StringBuilder
import java.nio.file.Paths

val PATH = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\resources\\"

fun main(args: Array<String>) {
    val FILE = args[0]

    val inputText = readFile("$PATH$FILE.txt")

    val compressed = lzwEncode(inputText)
    writeFile("$PATH${FILE}_compressed.txt", intToString(compressed))

    val compressedText = readFile("$PATH${FILE}_compressed.txt")
    val decompressed = lzwDecode(stringToInt(compressedText))
    writeFile("$PATH${FILE}_decompressed.txt", decompressed)
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
