import kotlin.random.Random

fun generateRandomText(size: Int): String {
    val res = StringBuilder("")
    for (i in 0..size) {
        res.append(Random.nextInt(0, 255).toChar())
    }
    return res.toString()
}
