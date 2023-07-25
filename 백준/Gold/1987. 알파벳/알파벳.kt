fun main() {
    val (r, c) = readln().split(" ").map(String::toInt)
    val map = Array(r) { readln().toCharArray().map { it - 'A' }.toIntArray() }
    val visited = BooleanArray(('A'..'Z').count())
    var answer = 0
    val dy = intArrayOf(0, -1, 0, 1)
    val dx = intArrayOf(-1, 0, 1, 0)

    fun dfs(
        row: Int,
        column: Int,
        cnt: Int
    ) {
        answer = Math.max(answer, cnt)

        for (k in 0 until 4) {
            val dRow = row + dy[k]
            val dColumn = column + dx[k]

            if (dRow !in 0 until r || dColumn !in 0 until c || visited[map[dRow][dColumn]]) continue

            val nextChar = map[dRow][dColumn]
            visited[nextChar] = true
            dfs(dRow, dColumn, cnt + 1)
            visited[nextChar] = false
        }
    }

    visited[map[0][0]] = true
    dfs(0, 0, 1)
    println(answer)
}