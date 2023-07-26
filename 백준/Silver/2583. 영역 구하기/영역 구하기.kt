import java.util.LinkedList

fun main() {
    val (m, n, k) = readln().split(' ').map(String::toInt)
    val map = Array(m) { IntArray(n) }
    repeat(k) {
        readln().split(' ').map(String::toInt).let { (a, b, c, d) ->
            for (row in b until d) {
                for (col in a until c) {
                    map[row][col] = 1
                }
            }
        }
    }
    val visited = Array(m) { BooleanArray(n) }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun bfs(row: Int, col: Int): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        var size = 0
        queue.offer(row to col)
        visited[row][col] = true
        size++
        while (queue.isNotEmpty()) {
            val current = queue.poll()!!

            for (j in 0 until 4) {
                val dr = current.first + dx[j]
                val dc = current.second + dy[j]

                if (dr !in 0 until m || dc !in 0 until n) continue

                if (map[dr][dc] == 0 && !visited[dr][dc]) {
                    queue.offer(dr to dc)
                    visited[dr][dc] = true
                    size++
                }
            }
        }
        return size
    }

    val results = mutableListOf<Int>()
    for (row in 0 until m) {
        for (col in 0 until n) {
            if (map[row][col] == 0 && !visited[row][col]) {
                val result = bfs(row, col)
                results.add(result)
            }
        }
    }
    println(results.size)
    results.sort()
    println(results.joinToString(" "))
}