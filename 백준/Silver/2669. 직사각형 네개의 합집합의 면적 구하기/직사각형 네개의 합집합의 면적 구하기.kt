fun main() {
    data class Point(
        val x: Int,
        val y: Int,
        val topX: Int,
        val topY: Int
    )

    val board = Array(101) { IntArray(101) }
    val inputs = List(4) { readln().split(" ").map(String::toInt).run { Point(this[0], this[1], this[2], this[3]) } }

    inputs.forEach {
        for (i in it.y until it.topY) {
            for (j in it.x until it.topX) {
                board[i][j] = 1
            }
        }
    }

    println(board.flatMap { it.toList() }.count { it == 1 })
}