fun main() {
    val n = readln().toInt()
    var winNumber = 0
    var winSum = 0
    for (i in 0 until n) {
        val maxSum = readln().split(" ").map(String::toInt).toIntArray().getSum()
        if (winSum > maxSum) continue
        winSum = maxSum
        winNumber = i + 1
    }
    println(winNumber)
}

private fun IntArray.getSum(): Int {
    var max = 0
    for (i in 0 until 3) {
        for (j in i + 1 until 4) {
            for (k in j + 1 until 5) {
                max = maxOf(max, (this[i] + this[j] + this[k]) % 10)
            }
        }
    }
    return max
}