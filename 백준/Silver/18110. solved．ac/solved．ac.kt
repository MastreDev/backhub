import kotlin.math.roundToInt

fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println(0)
        return
    }
    val ratings = List(n) { readln().toInt() }
    val exceptCount = 0.15.times(n).roundToInt()
    println(ratings.sorted().drop(exceptCount).dropLast(exceptCount).average().roundToInt())
}