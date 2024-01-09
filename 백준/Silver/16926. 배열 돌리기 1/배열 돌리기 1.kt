fun main() {
    val (n, m, r) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }

    fun rotate(skip: Int) {
        val remain = board[skip][skip]
        val rowEnd = n - skip
        val colEnd = m - skip

        for (i in skip + 1 until m - skip) {
            board[skip][i - 1] = board[skip][i]
        }
        for (i in skip + 1 until n - skip) {
            board[i - 1][colEnd - 1] = board[i][colEnd - 1]
        }
        for (i in colEnd - 1 downTo skip + 1) {
            board[rowEnd - 1][i] = board[rowEnd - 1][i - 1]
        }
        for (i in rowEnd - 1 downTo skip + 1) {
            board[i][skip] = board[i - 1][skip]
        }
        board[skip + 1][skip] = remain
    }

    val innerCircleCount = minOf(n, m) / 2
    repeat(r) { _ ->
        repeat(innerCircleCount) {
            rotate(it)
        }
    }

    board
        .fold(StringBuilder()) { acc, row ->
            acc.appendLine(row.joinToString(" "))
        }
        .also {
            println(it.toString())
        }
}