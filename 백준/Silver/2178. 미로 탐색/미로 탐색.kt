import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val map = Array(n) {
        readln().toCharArray().map(Char::digitToInt).toIntArray()
    }
    val visited = Array(n) { BooleanArray(m) }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun bfs() : Int {
        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.offer(Triple(0, 0, 1))
        visited[0][0] = true

        all@ while (queue.isNotEmpty()) {
            val node = queue.poll()!!

            if (node.first == n - 1 && node.second == m - 1) {
                return node.third
            }

            for (k in 0 until 4) {
                val dr = node.first + dx[k]
                val dc = node.second + dy[k]

                if (dr !in 0 until n || dc !in 0 until m) continue

                if (map[dr][dc] == 1 && !visited[dr][dc]) {
                    queue.offer(Triple(dr, dc, node.third + 1))
                    visited[dr][dc] = true
                }
            }
        }
        return 0
    }

    val result = bfs()
    println(result)
}