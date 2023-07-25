import java.util.LinkedList

fun main() {
    val (m, n) = readln().split(' ').map(String::toInt)
    val map = Array(n) {
        readln().split(' ').map(String::toInt).toIntArray()
    }
    val dist = Array(n) { IntArray(m)}
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(n){row->
        repeat(m){col->
            if (map[row][col] == 1) {
                queue.offer(row to col)
            }
            if (map[row][col] == 0) {
                dist[row][col] = -1
            }
        }
    }

    fun bfs() {
        while (queue.isNotEmpty()) {
            val current = queue.poll()!!

            for (k in 0 until 4) {
                val dr = current.first + dx[k]
                val dc = current.second + dy[k]

                if (dr !in 0 until n || dc !in 0 until m) continue
                if (dist[dr][dc] >= 0) continue
                dist[dr][dc] = dist[current.first][current.second] + 1
                queue.offer(dr to dc)
            }
        }
    }

    bfs()

    var answer = 0
    all@ for (row in 0 until n) {
        for (col in 0 until m) {
            if(dist[row][col] == -1) {
                answer = -1
                break@all
            }
            answer = maxOf(answer, dist[row][col])
        }
    }
    println(answer)
}
