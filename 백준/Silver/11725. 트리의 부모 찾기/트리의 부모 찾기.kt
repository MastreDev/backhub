import java.util.LinkedList

fun main() {
    val n = readln().toInt() // max = 100_000
    val nodeMap = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        readln().split(' ').map(String::toInt).let { (a, b) ->
            nodeMap[a].add(b)
            nodeMap[b].add(a)
        }
    }

    val visited = IntArray(n + 1) { 0 }
    fun bfs() {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(-1 to 1)

        while (queue.isNotEmpty()) {
            val current = queue.poll()!!
            visited[current.second] = current.first
            val children = nodeMap[current.second]
            for (i in 0 until children.size) {
                if (visited[children[i]] != 0) continue
                queue.offer(current.second to children[i])
            }
        }
    }
    bfs()
    visited.drop(2).joinToString("\n").also { print(it) }
}