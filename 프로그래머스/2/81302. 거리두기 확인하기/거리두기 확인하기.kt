import java.util.LinkedList

class Solution {
private var oo: Array<Array<CharArray>> = Array(5) { Array(5) { CharArray(5) } }

    fun solution(places: Array<Array<String>>): IntArray {
        for (i in 0 until places.size) {
            for (j in 0 until places[0].size) {
                oo[i][j] = places[i][j].toCharArray()
            }
        }
        val answer = IntArray(5)

        places.forEachIndexed { index, waiting ->
            val results = mutableListOf<Boolean>()
            for (i in 0 until waiting.size) {
                for (j in 0 until waiting[i].length) {
                    if (waiting[i][j] == 'P') {
                        results.add(findP(index, i, j))
                    }
                }
            }
            answer[index] = if (results.isEmpty()) 1 else 1.takeIf { results.all { it } } ?: 0
        }

        return answer.also { println(it.contentToString()) }
    }

    private val dx = arrayOf(-1, 0, 1, 0)
    private val dy = arrayOf(0, -1, 0, 1)

    private fun findP(roomNumber: Int, startR: Int, startC: Int): Boolean {
        val check: Array<Array<IntArray>> = Array(5) { Array(5) { IntArray(5) } }
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(startR to startC)
        check[roomNumber][startR][startC] = 1
        var isValid = true

        search@ while (queue.isNotEmpty()) {
            val (row, col) = queue.poll()!!
            for (i in 0 until 4) {
                val nr = row + dy[i]
                val nc = col + dx[i]

                if (nr !in 0 until 5 || nc !in 0 until 5) continue
                if (oo[roomNumber][nr][nc] == 'X') continue
                if (check[roomNumber][nr][nc] > 0) continue
                if (oo[roomNumber][nr][nc] == 'P') {
                    check[roomNumber][nr][nc] = check[roomNumber][row][col] + 1
                    if (check[roomNumber][nr][nc] < 4) {
                        isValid = false
                        break@search
                    }
                }
                if (oo[roomNumber][nr][nc] == 'O') {
                    check[roomNumber][nr][nc] = check[roomNumber][row][col] + 1
                }
                queue.offer(nr to nc)
            }
        }
        return isValid
    }
}