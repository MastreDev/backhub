import kotlin.math.absoluteValue

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val j = readln().toInt()
    var basketStart = 0
    var basketEnd = m - 1
    var moveCount = 0

    repeat(j) {
        val point = readln().toInt() - 1
        val gap = when {
            point < basketStart -> point - basketStart
            basketEnd < point -> point - basketEnd
            else -> 0
        }
        basketStart += gap
        basketEnd += gap
        moveCount += gap.absoluteValue
    }
    println(moveCount)
}