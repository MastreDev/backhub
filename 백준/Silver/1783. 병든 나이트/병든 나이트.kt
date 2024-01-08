fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    when {
        n == 1 -> 1
        n == 2 -> 4.takeIf { m >= 7 } ?: ((m + 1) / 2)
        m < 7 -> minOf(4, m)
        else -> m - 2
    }.also { println(it) }
}