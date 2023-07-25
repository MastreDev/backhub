import java.util.*

/*
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.
    입력으로 주어지는 간선은 양방향이다.
*/
fun main() {

    val (n, m, v) = readln().split(" ").map(String::toInt)
    val edges = (1..n).zip(Array(n) { mutableListOf<Int>() })
        .toMap()
        .apply {
            repeat(m) {
                readln().split(" ")
                    .map(String::toInt)
                    .also { (a, b) ->
                        get(a)?.add(b)
                        get(b)?.add(a)
                    }
            }
        }

    //Do
    val bfsResult = ArrayList<String>()
    val visited = BooleanArray(n + 1)
    doBfs(v, visited, edges, bfsResult)
    visited.fill(false)

    val dfsResult = ArrayList<String>()
    doDfs(v, visited, edges, dfsResult)

    //output
    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}

fun doBfs(
    start: Int,
    visited: BooleanArray,
    edges: Map<Int, List<Int>>,
    result: ArrayList<String>
) {
    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true
    result.add(start.toString())

    while (queue.isNotEmpty()) {
        val target = queue.poll()!!

        for (next in edges.getOrDefault(target, listOf()).sorted()) {
            if (!visited[next]) {
                result.add(next.toString())
                visited[next] = true
                queue.addLast(next)
            }
        }
    }
}

fun doDfs(
    start: Int,
    visited: BooleanArray,
    edges: Map<Int, List<Int>>,
    result: ArrayList<String>
) {
    visited[start] = true
    result.add(start.toString())

    for (next in edges.getOrDefault(start, listOf()).sorted()) {
        if (!visited[next]) {
            doDfs(next, visited, edges, result)
        }
    }
}
