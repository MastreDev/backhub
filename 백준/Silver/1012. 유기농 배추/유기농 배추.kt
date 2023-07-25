fun main() {
    val t = readln().toInt()
    val testCases = Array(t) { TestCase() }
    repeat(t) {
        val (m, n, k) = readln().split(" ").map(String::toInt)
        val map = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }
        repeat(k) {
            val (row, column) = readln().split(" ").map(String::toInt)
            map[column][row] = 1
        }
        testCases[it] = TestCase(map, visited)
    }

    testCases.forEach { tc ->
        var answer = 0
        tc.map.forEachIndexed { row, ints ->
            ints.forEachIndexed { column, isFilled ->
                if (isFilled == 1 && !tc.visited[row][column]) {
                    dfs(row, column, tc.map, tc.visited)
                    answer++
                }
            }
        }
        println(answer)
    }
}

private fun dfs(row: Int, column: Int, map: Array<IntArray>, visited: Array<BooleanArray>) {
    visited[row][column] = true

    //좌, 상, 우, 하 로 변경
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (k in 0 until 4) {
        val nx = row + dx[k]
        val ny = column + dy[k]

        if (map.checkOut(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
            dfs(nx, ny, map, visited)
        }
    }
}

private fun Array<IntArray>.checkOut(i: Int, j: Int): Boolean {
    if (i < 0 || i >= this.size || j < 0 || j >= this[0].size) return false
    return true
}

private class TestCase(
    val map: Array<IntArray> = arrayOf(),
    val visited: Array<BooleanArray> = arrayOf()
)