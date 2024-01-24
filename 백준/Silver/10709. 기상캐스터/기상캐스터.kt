fun main() {

    val (r, c) = readln().split(" ").map(String::toInt)
    val village = Array(r) { readln().toCharArray() }
    val dp = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        dp[i][0] = 0.takeIf { village[i][0] == 'c' } ?: -1
    }

    for (i in 0 until r) {
        for (j in 1 until c) {
            val current = village[i][j]
            if (current == 'c') {
                dp[i][j] = 0
                continue
            }
            val pre = dp[i][j - 1]
            dp[i][j] = if (pre < 0) -1 else pre + 1
        }
    }
    val result = StringBuilder()
    dp.forEach {
        result.appendLine(it.joinToString(" "))
    }
    print(result.toString())
}