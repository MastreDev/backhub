fun main() {
    val rowAndColumn = readln().toInt()
    val canvas = Array(rowAndColumn) { CharArray(rowAndColumn) }
    val visited = Array(rowAndColumn) { BooleanArray(rowAndColumn) }
    repeat(rowAndColumn) {
        canvas[it] = readln().toCharArray()
    }

    booleanArrayOf(false, true).forEach { isColorBlindness ->
        var answer = 0
        if(isColorBlindness) {
            canvas.forEachIndexed { row, chars ->
                chars.forEachIndexed { column, color ->
                    if(color == 'G') canvas[row][column] = 'R'
                }
            }
        }
        canvas.forEachIndexed { row, chars ->
            chars.forEachIndexed { column, color ->
                if (!visited[row][column]) {
                    dfs(row, column, color, canvas, visited)
                    answer++
                }
            }
        }
        println(answer)
        visited.forEach { it.fill(false) }
    }
}

private fun dfs(
    row: Int,
    column: Int,
    color: Char,
    canvas: Array<CharArray>,
    visited: Array<BooleanArray>
) {
    visited[row][column] = true

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (k in 0 until 4) {
        val nx = row + dx[k]
        val ny = column + dy[k]

        if (canvas.checkOut(nx, ny) && !visited[nx][ny] && canvas[nx][ny] == color) {
            dfs(nx, ny, color, canvas, visited)
        }
    }

}

private fun Array<CharArray>.checkOut(i: Int, j: Int): Boolean {
    if (i < 0 || i >= this.size || j < 0 || j >= this[0].size) return false
    return true
}