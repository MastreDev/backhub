fun main() {
    val t = readln().toInt()
    val max = 14
    repeat(t) {
        val k = readln().toInt()
        val n = readln().toInt()

        val dp = Array(max + 1) { IntArray(max + 1) }
        for(i in 0 until max+1) {
            dp[0][i] = i
        }
        for (i in 1 until max + 1) {
            for (j in 1 until max + 1) {
                dp[i][j] = dp[i-1][j] + dp[i][j -1]
            }
        }
        println(dp[k][n])
    }
}