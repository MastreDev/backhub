fun main() {
    val n = readln().toInt()
    val t = Array(n + 1) { 0 }
    val p = Array(n + 1) { 0 }

    for (i in 1..n) {
        readln().split(' ').map(String::toInt).also { (a, b) ->
            t[i] = a
            p[i] = b
        }
    }

    var answer = 0
    fun dfs(day: Int, sumProfit: Int) {
        if (day > n) {
            answer = Math.max(answer, sumProfit)
            return
        }
        
        val endDay = day + t[day]
        if (endDay <= n + 1) {
            dfs(endDay, sumProfit + p[day])
        } else {
            dfs(endDay, sumProfit)
        }
        dfs(day + 1, sumProfit)
    }
    dfs(1, 0)
    println(answer)
}