import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val map = Array(n) { readln().toCharArray() }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    val exits = mutableListOf<Pair<Int, Int>>()
    repeat(n) { row ->
        repeat(m) { col ->
            if (map[row][col] == '.' && (row == 0 || col == 0 || row == n - 1 || col == m - 1))
                exits.add(row to col)
        }
    }

    fun bfs(queue: Queue<Pair<Int, Int>>, dist: Array<IntArray>) {
        while (queue.isNotEmpty()) {
            val current = queue.poll()!!

            for (k in 0 until 4) {
                val dr = current.first + dx[k]
                val dc = current.second + dy[k]

                if (dr !in 0 until n || dc !in 0 until m) continue

                if (map[dr][dc] != '#' && map[dr][dc] != 'F' && dist[dr][dc] == -1) {
                    queue.offer(dr to dc)
                    dist[dr][dc] = dist[current.first][current.second] + 1
                }
            }
        }
    }

    val fireDist = Array(n) { IntArray(m) { -1 } }
    val johnDist = Array(n) { IntArray(m) { -1 } }

    val queue = LinkedList<Pair<Int, Int>>()
    repeat(n) { row ->
        repeat(m) { col ->
            if (map[row][col] == 'F') {
                queue.offer(row to col)
                fireDist[row][col] = 0
            }
        }
    }
    bfs(queue, fireDist)
    all@ for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'J') {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                    println(1)
                    return
                }
                queue.offer(i to j)
                johnDist[i][j] = 0
                break@all
            }
        }
    }
    bfs(queue, johnDist)
    exits
        .filter { (row, col) -> johnDist[row][col] > 0 }
        .filter { (row, col) -> johnDist[row][col] < fireDist[row][col] || fireDist[row][col] == -1 }
        .map { (row, col) -> johnDist[row][col] + 1 }
        .ifEmpty { listOf(-1) }
        .minOf { it }
        .apply { println("IMPOSSIBLE".takeIf { this == -1 } ?: this.toString()) }
}