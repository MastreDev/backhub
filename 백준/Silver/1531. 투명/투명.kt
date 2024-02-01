import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = arrayOf(0, 1)
private val dy = arrayOf(-1, 0)

fun main() {
    // 100 * 100
    val board = Array(100) { IntArray(100) }
    val (n, m) = br.readLine().split(" ").map(String::toInt) //0, 0 가능
    val papers = Array(n) { br.readLine().split(" ").map(String::toInt) }

    fun fill(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        val (startRow, startCol) = start
        val (endRow, endCol) = end
        val queue = LinkedList<Pair<Int, Int>>()
        val filled = Array(100) { IntArray(100) }
        queue.offer(startRow to startCol)
        board[startRow][startCol]++
        filled[startRow][startCol] = 1

        while (queue.isNotEmpty()) {
            val (row, col) = queue.poll()!!
            for (i in 0 until 2) {
                val nr = row + dy[i]
                val nc = col + dx[i]
                if (nr !in endRow..startRow || nc !in startCol..endCol) continue
                if (filled[nr][nc] == 0) {
                    board[nr][nc]++
                    filled[nr][nc] = 1
                    queue.offer(nr to nc)
                }
            }
        }
    }

    papers.forEach {
        fill(parse(it[0], it[1]), parse(it[2], it[3]))
    }
    bw.write(board.flatMap { it.toList() }.count { it > m }.toString())
    br.close()
    bw.close()
}

private fun parse(x: Int, y: Int): Pair<Int, Int> {
    return (100 - y to x - 1)
}