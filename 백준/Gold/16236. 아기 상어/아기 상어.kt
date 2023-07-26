import java.util.LinkedList

fun main() {
    val maxN = 21
    val n = readln().toInt()
    val map = Array(n) {
        readln().split(' ').map(String::toInt).toIntArray()
    }
    var bShark = 0 to 0
    var bSharkSize = 2

    val range = 0 until n
    for (i in range) {
        for (j in range) {
            if (map[i][j] == 9) {
                bShark = i to j
                map[i][j] = 0
            }
        }
    }

    var minDist = maxN * maxN
    var minTarget = maxN to maxN

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun bfs(start: Pair<Int, Int>, dist: Array<IntArray>) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(start)
        dist[start.row][start.col] = 0

        while (queue.isNotEmpty()) {
            val (cRow, cCol) = queue.poll()!!

            for (k in 0 until 4) {
                val dr = cRow + dx[k]
                val dc = cCol + dy[k]

                if (dr !in range || dc !in range) continue
                if (map[dr][dc] > bSharkSize || dist[dr][dc] != -1) continue

                dist[dr][dc] = dist[cRow][cCol] + 1

                //먹을 수 있는 물고기라면...
                if (map[dr][dc] != 0 && map[dr][dc] < bSharkSize) {

                    if (dist[dr][dc] < minDist) {
                        minDist = dist[dr][dc]
                        minTarget = dr to dc

                    } else if (dist[dr][dc] == minDist) {
                        if (minTarget.row == dr) {
                            if(dc < minTarget.col) {
                                minTarget = dr to dc
                            }
                        } else if (dr < minTarget.row) {
                            minTarget = dr to dc
                        }
                    }
                }
                queue.offer(dr to dc)
            }
        }
    }

    var eatCount = 0
    var answer = 0

    while (true) {
        minDist = 401
        minTarget = 21 to 21
        val dist = Array(n) { IntArray(n) { -1 } }

        bfs(bShark, dist)

        if (minTarget.row == maxN || minTarget.col == maxN) break

        answer += dist[minTarget.row][minTarget.col]

        eatCount++

        if (eatCount == bSharkSize) {
            bSharkSize++
            eatCount = 0
        }

        //잡아 먹기
        map[minTarget.row][minTarget.col] = 0

        bShark = minTarget.copy()
    }
    println(answer)
}

private val Pair<Int, Int>.row get() = this.first
private val Pair<Int, Int>.col get() = this.second