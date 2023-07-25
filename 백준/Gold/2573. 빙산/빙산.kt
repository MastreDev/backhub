fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val map = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
    var yearCount = 0
    var massCount = 0
    val dy = intArrayOf(0, -1, 0, 1)
    val dx = intArrayOf(-1, 0, 1, 0)

    fun meltBerg(point: Pair<Int, Int>) {
        val visited = Array(n) { BooleanArray(m) }

        fun dfs(row: Int, column: Int) {
            visited[row][column] = true
            var seaCount = 0
            for (k in 0 until 4) {
                val dRow = row + dy[k]
                val dColumn = column + dx[k]
                if (dRow !in 0 until n || dColumn !in 0 until m || visited[dRow][dColumn]) continue
                if (map[dRow][dColumn] == 0 && !visited[dRow][dColumn]) seaCount++
                if (map[dRow][dColumn] == 0) continue
                dfs(dRow, dColumn)
            }
            map[row][column] = Math.max(map[row][column] - seaCount, 0)
        }

        dfs(point.first, point.second)
        yearCount++
    }

    fun findIceBerg() {
        val visited = Array(n) { BooleanArray(m) }
        fun dfs(row: Int, column: Int) {
            visited[row][column] = true
            for (k in 0 until 4) {
                val dRow = row + dy[k]
                val dColumn = column + dx[k]
                if (dRow !in 0 until n || dColumn !in 0 until m || visited[dRow][dColumn]) continue
                if (map[dRow][dColumn] == 0) continue
                dfs(dRow, dColumn)
            }
        }

        var findMass = 0
        visited.forEach { it.fill(false) }
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j)
                    findMass++
                }
            }
        }
        massCount = findMass
    }

    while (massCount < 2) {
        meltBerg(map.getStartPoint())
        findIceBerg()
        if(map.sumOf { it.sum() } == 0) {
            yearCount = 0
            break
        }
    }
    println(yearCount)
}

private fun Array<IntArray>.getStartPoint(): Pair<Int, Int> {
    for (i in this.indices) {
        for (j in this[i].indices) {
            if (this[i][j] != 0) {
                return i to j
            }
        }
    }
    return 0 to 0
}