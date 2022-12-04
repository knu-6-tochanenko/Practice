import java.lang.StringBuilder

const val DICTIONARY_SIZE = 256

fun lzwEncode(text: String): List<Int> {
    var dictionarySize = DICTIONARY_SIZE

    // Populate dictionary for basic ASCII characters
    val dictionary = mutableMapOf<String, Int>()
    for (i in 0 until dictionarySize) {
        dictionary[i.toChar().toString()] = i
    }

    // Add codes for found sequences
    var found = "";
    val result = mutableListOf<Int>()
    for (i in text.indices) {
        val charsToAdd = found + text[i]
        if (dictionary.containsKey(charsToAdd)) {
            found = charsToAdd
        } else {
            result.add(dictionary[found]!!)
            dictionary[charsToAdd] = dictionarySize++
            found = text[i].toString()
        }
    }

    if (found.isNotEmpty()) {
        result.add(dictionary[found]!!)
    }

    return result
}

fun lzwDecode(encodedText: MutableList<Int>): String {
    var dictionarySize = DICTIONARY_SIZE
    val dictionary = mutableMapOf<Int, String>()

    // Populate dictionary for basic ASCII characters
    for (i in 0 until dictionarySize) {
        dictionary[i] = i.toChar().toString()
    }

    var characters: String = encodedText.removeFirst().toChar().toString()
    val result = StringBuilder(characters)

    for (i in encodedText.indices) {
        val entry = if (dictionary.containsKey(encodedText[i])) dictionary[encodedText[i]] else characters + characters[0]
        result.append(entry)
        dictionary[dictionarySize++] = characters + entry!![0]
        characters = entry
    }

    return result.toString()
}
