import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val graph = Array(n + 1) { IntArray(n + 1) }
    repeat(m) {
        readln().split(' ').map(String::toInt).let { (a, b) ->
            graph[a][b] = 1
            graph[b][a] = 1
        }
    }
    fun dfs(start: Int, dist: IntArray) {
        val queue = LinkedList<Int>()
        queue.add(start)
        dist[start] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()!!
            val children = graph[current]

            for (k in children.indices) {
                if (children[k] == 1 && dist[k] == -1) {
                    queue.offer(k)
                    dist[k] = dist[current] + 1
                }
            }
        }
    }

    var answer = Int.MAX_VALUE
    var result = 1
    (1..n).forEach {
        val dist = IntArray(n + 1) { -1 }
        dfs(it, dist)
        val edges = dist.filter { edge -> edge > 0 }.sum()
        if (edges in 1 until answer) {
            result = it
            answer = edges
        }
    }
    println(result)
}