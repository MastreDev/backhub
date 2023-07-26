import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { IntArray(n + 1) }
    val (a1, a2) = readln().split(' ').map(String::toInt)
    val m = readln().toInt()
    val dist = IntArray(n + 1) { -1 }

    repeat(m) {
        readln().split(' ').map(String::toInt).let { (a, b) ->
            graph[a][b] = 1
            graph[b][a] = 1
        }
    }

    fun bfs(from: Int, to: Int) {
        val queue = LinkedList<Int>()
        queue.offer(from)
        dist[from] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()!!

            if (current == to) break

            val edges = graph[current]
            for (k in edges.indices) {
                if (edges[k] == 1 && dist[k] == -1) {
                    queue.offer(k)
                    dist[k] = dist[current] + 1
                }
            }
        }
    }

    val from = minOf(a1, a2)
    val to = maxOf(a1, a2)

    bfs(from, to)
    println(dist[to])
}