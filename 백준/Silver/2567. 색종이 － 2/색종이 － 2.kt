fun main() {
    val side = 100
    val n = readln().toInt()
    val points = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
    val board = Array(side) { IntArray(side) }

    fun attachPaper(x: Int, y: Int) {
        val row = side - 1 - y
        val col = x

        repeat(10) { a ->
            repeat(10) { b ->
                board[row - a][col + b] = 1
            }
        }
    }

    points.forEach {
        attachPaper(it[0], it[1])
    }

    val range = 0 until 100

    var heights = 0
    var widths = 0

    for (i in range) {
        val row = board[i]
        var last = 0
        for (j in range) {
            val current = row[j]
            if (last == current) continue
            heights++
            last = current
        }
        if (last == 1) heights++
    }

    for (i in range) {
        var last = 0
        for (j in range) {
            val current = board[j][i]
            if (last == current) continue
            widths++
            last = current
        }
        if (last == 1) widths++
    }
    println(widths + heights)
}