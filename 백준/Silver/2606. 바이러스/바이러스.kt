fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val countComputers = br.readLine().toInt()
    val pairCounts = br.readLine().toInt()
    val connections = mutableListOf<Pair<Int, Int>>()

    repeat(pairCounts) {
        val raw = br.readLine().split(" ")
        val computer1 = raw[0].toInt()
        val computer2 = raw[1].toInt()
        connections.add(computer1 to computer2)
        connections.add(computer2 to computer1)
    }

    val result = solve(connections)

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun solve(connections: List<Pair<Int, Int>>): Int {
    val graph = HashMap<Int, MutableList<Int>>()
    connections.forEach {
        val key = it.first
        if (graph[key] == null) {
            graph[key] = mutableListOf(it.second)
        } else {
            graph[key]!!.add(it.second)
        }
    }
    val visited = mutableSetOf<Int>()
    dfsRecursive(1, visited, graph)
    val result = visited.filterNot { it == 1 }
    return result.count()
}

fun dfsRecursive(node: Int, visited: MutableSet<Int>, graph: Map<Int, List<Int>>) {
    visited.add(node)
    for (neighbor in graph[node] ?: emptyList()) {
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited, graph)
        }
    }
}