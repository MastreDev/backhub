import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val map = Array(n) {
        readln().split(' ').map(String::toInt).toIntArray()
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun bfs(start: Int, end: Int, level: Int, visited: Array<BooleanArray>): Int {
        val queue = LinkedList<Node>()
        queue.offer(Node(start, end))
        visited[start][end] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()!!

            for (k in 0 until 4) {
                val dr = current.row + dx[k]
                val dc = current.col + dy[k]

                if (dr !in 0 until n || dc !in 0 until n) continue
                if (!visited[dr][dc] && map[dr][dc] >= level) {
                    queue.offer(Node(dr, dc))
                    visited[dr][dc] = true
                }
            }
            if (queue.isEmpty()) return 1
        }
        return 0
    }

    var answer = Int.MIN_VALUE
    (1..100).forEach { level ->
        val visited = Array(n) { BooleanArray(n) }
        var count = 0

        map.indices.forEach { row ->
            map[row].indices.forEach { col ->
                if (map[row][col] >= level && !visited[row][col]) {
                    count += bfs(row, col, level, visited)
                }
            }
        }
        answer= maxOf(answer, count)
    }
    println(answer)

}

private data class Node(
    val row: Int,
    val col: Int,
)