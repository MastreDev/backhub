fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val arr = Array(n) {
        readln().split(" ").map(String::toInt).toIntArray()
    }
    val results = StringBuilder()
    val k = readln().toInt()
    repeat(k) {
        val split = readln().split(" ").map(String::toInt)
        val (i, j, x, y) = split
        var sum = 0
        (i - 1 until x).forEach { xx ->
            (j - 1 until y).forEach { yy ->
                sum += arr[xx][yy]
            }
        }
        results.appendLine(sum)

    }
    println(results)
}