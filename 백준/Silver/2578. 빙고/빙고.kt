import java.util.LinkedList

fun main() {

    val board = Array(5) { readln().split(" ").map(String::toInt).toIntArray() }
    val markBoard = Array(5) { BooleanArray(5) }

    val calls = LinkedList<Int>().apply {
        repeat(5) {
            readln().split(" ").map(String::toInt).forEach { this.add(it) }
        }
    }

    fun validateRow(col: Int): Boolean {
        for (i in 0 until 5) {
            if (!markBoard[col][i]) return false
        }
        return true
    }

    fun validateCol(row: Int): Boolean {
        for (i in 0 until 5) {
            if (!markBoard[i][row]) return false
        }
        return true
    }

    fun validateDiagonal(row: Int, reverse: Boolean = false): Boolean {
        for (i in 0 until 5) {
            val check = if (reverse) markBoard[i][row - i] else markBoard[i][i]
            if (!check) return false
        }
        return true
    }

    fun checkLines(): Int {
        // line 3
        // 0, 0 ->  대각선
        var lineCount = 0
        lineCount += 1.takeIf { validateDiagonal(0) } ?: 0

        // 세로
        for (i in 0 until 5) {
            lineCount += 1.takeIf { validateCol(i) } ?: 0
        }

        // 0, 4 ->  대각선
        lineCount += 1.takeIf { validateDiagonal(4, true) } ?: 0

        // 가로
        for (i in 0 until 5) {
            lineCount += 1.takeIf { validateRow(i) } ?: 0
        }
        return lineCount
    }

    fun mark(number: Int) {
        stop@ for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (number != board[i][j]) continue
                markBoard[i][j] = true
                break@stop
            }
        }
    }

    var result = 0
    while (calls.isNotEmpty()) {
        result++
        val call = calls.poll()!!
        mark(call)
        val lineCount = checkLines()
        if (lineCount >= 3) break
    }
    println(result)
}