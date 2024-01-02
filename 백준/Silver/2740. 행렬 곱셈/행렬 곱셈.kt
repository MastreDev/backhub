fun main() {
    val (aN, aM) = readln().split(" ").map(String::toInt)
    val aArray = Array(aN) { readln().split(" ").map(String::toInt).toIntArray() }

    val (bN, bM) = readln().split(" ").map(String::toInt)
    val bArray = Array(bN) { readln().split(" ").map(String::toInt).toIntArray() }

    val result = Array(aN) { IntArray(bM) }

    for (i in 0 until aN) {
        for (j in 0 until bM) {
            var sum = 0
            for (k in 0 until aM) {
                sum += aArray[i][k] * bArray[k][j]
            }
            result[i][j] = sum
        }
    }
    val resultString = StringBuilder()
    result.forEach {
        resultString.appendLine(it.joinToString(" "))
    }
    print(resultString)
}