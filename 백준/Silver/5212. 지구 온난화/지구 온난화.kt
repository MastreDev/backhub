import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = arrayOf(-1, 0, 1, 0)
private val dy = arrayOf(0, -1, 0, 1)

fun main() {
    val (r, c) = br.readLine().split(" ").map(String::toInt)
    val map = Array(r) { br.readLine().toCharArray() }
    val newMap = Array(r) { map[it].copyOf() }
    val rowRange = 0 until r
    val colRange = 0 until c

    fun doBfs(start: Int, end: Int) {
        val queue = LinkedList<IntArray>()
        queue.offer(intArrayOf(start, end))

        while (queue.isNotEmpty()) {
            val (row, col) = queue.poll()!!
            var seaCount = 0
            for (i in 0 until 4) {
                val nr = row + dy[i]
                val nc = col + dx[i]
                if (nr !in rowRange || nc !in colRange) {
                    seaCount++
                    continue
                }
                if (map[nr][nc] == '.') seaCount++
            }
            if (seaCount > 2) newMap[row][col] = '.'
        }
    }

    for (i in rowRange) {
        for (j in colRange) {
            if (map[i][j] == 'X') {
                doBfs(i, j)
            }
        }
    }

    var startRow = 0
    var startCol = 0
    var endRow = 0
    var endCol = 0

    for (i in rowRange) {
        if (!newMap[i].fold(true) { acc, cc -> cc == '.' && acc }) {
            startRow = i
            break
        }
    }

    for (i in r - 1 downTo 0) {
        if (!newMap[i].fold(true) { acc, cc -> cc == '.' && acc }) {
            endRow = i
            break
        }
    }

    for (j in colRange) {
        var isEmpty = true
        for (i in rowRange) {
            isEmpty = (isEmpty && newMap[i][j] == '.')
        }
        if (!isEmpty) {
            startCol = j
            break
        }
    }

    for (j in c - 1 downTo 0) {
        var isEmpty = true
        for (i in rowRange) {
            isEmpty = (isEmpty && newMap[i][j] == '.')
        }
        if (!isEmpty) {
            endCol = j
            break
        }
    }

    for (i in startRow..endRow) {
        for (j in startCol..endCol) {
            bw.write(newMap[i][j].toString())
        }
        bw.newLine()
    }
    bw.close()
}