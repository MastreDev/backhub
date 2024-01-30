private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

private val dx = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)
private val dy = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)

fun main() {
    val rStart = br.readLine()
    val startRow = 54 - rStart[1].code
    val startCol = rStart[0].code - 65
    val board = Array(6) { IntArray(6) { 0 } }
    board[startRow][startCol] = 1
    var lastRow = startRow
    var lastCol = startCol

    repeat(35) { _ ->
        val rl = br.readLine()
        val row = 54 - rl[1].code
        val col = rl[0].code - 65

        val lasts = List(8) { lastRow + dy[it] to lastCol + dx[it] }.toSet()
        if (row to col !in lasts) return@repeat
        board[row][col]++
        lastRow = row
        lastCol = col


    }

    val isTour = board.flatMap { it.toList() }.fold(true) { acc, b -> acc && b == 1 }
    val lasts = List(8) { startRow + dy[it] to startCol + dx[it] }.toSet()
    if (isTour && lastRow to lastCol in lasts) {
        bw.write("Valid")
    } else {
        bw.write("Invalid")
    }
    bw.close()
    br.close()
}