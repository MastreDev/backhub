import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val target = readln().toInt()
    val board = Array(n) { IntArray(n) }
    val numbers = ((n * n) - 1 downTo 1).toCollection(LinkedList())

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    var point = 0 to 0

    fun fillCycle() {
        var direction = 0
        var row = 0
        var col = 0
        val range = 0 until n

        board[0][0] = n * n

        while (numbers.isNotEmpty()) {
            val next = direction % 4
            val dr = row + dy[next]
            val dc = col + dx[next]
            if (dr in range && dc in range && board[dr][dc] == 0) {
                val number = numbers.poll()!!
                board[dr][dc] = number
                if (number == target) {
                    point = dr to dc
                }
                row = dr
                col = dc
            } else {
                direction++
            }
        }
    }

    fillCycle()


    board.fold(StringBuilder()) { acc, r ->
        acc.appendLine(r.joinToString(" "))
    }.also {
        it.appendLine("${point.first + 1} ${point.second + 1}")
        print(it.toString())
    }

}