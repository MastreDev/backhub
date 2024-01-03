import kotlin.math.pow

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().toList().map(Char::digitToInt).toIntArray() }
    val resultLength = minOf(n, m)
    var result = 0

    val widthRange = 0 until n
    val heightRange = 0 until m

    for (i in 0 until n) {
        for (j in 0 until m) {
            val topLeft = board[i][j]
            for (k in resultLength - 1 downTo 1) {
                if (i + k !in widthRange || j + k !in heightRange) continue
                if (k <= result) break
                // 우측
                val topRight = board[i][j + k]
                if (topLeft != topRight) continue
                // 아래
                val bottomLeft = board[i + k][j]
                if (topLeft != bottomLeft) continue
                // 대각선
                val bottomRight = board[i + k][j + k]
                if (topLeft != bottomRight) continue
                result = maxOf(result, k)
            }
        }
    }
    println(result.plus(1.0).pow(2).toInt())
}