package kr.mastre.codingtest.bj

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { IntArray(n + 1) }
    val visited = BooleanArray(n + 1)
    repeat(m) {
        readln().split(' ').map(String::toInt).also { (r, c) ->
            graph[r][c] = 1
            graph[c][r] = 1
        }
    }

    fun dfs(row: Int) {
        visited[row] = true
        graph[row].forEachIndexed { c, v ->
            if (!visited[c] && v == 1) {
                dfs(c)
            }
        }
    }

    var answer = 0
    for (i in visited.indices) {
        if (i == 0 || visited[i]) continue
        dfs(i)
        answer++
    }

    println(answer)

}