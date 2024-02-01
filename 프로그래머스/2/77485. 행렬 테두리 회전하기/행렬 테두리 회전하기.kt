import java.util.LinkedList

class Solution {
    
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        val queue = LinkedList<Int>().apply { repeat(rows * columns) { this.add(it + 1) } }
        val board = Array(rows) { IntArray(columns) { queue.poll()!! } }

        queries.forEach { ro ->
            val circle = ArrayDeque<Int>()
            val startR = ro[0] - 1
            val startC = ro[1] - 1
            val endR = ro[2] - 1
            val endC = ro[3] - 1

            for (i in startC..endC) {
                circle.add(board[startR][i])
            }
            for (i in startR + 1..endR) {
                circle.add(board[i][endC])
            }
            for (i in endC - 1 downTo startC) {
                circle.add(board[endR][i])
            }
            for (i in endR - 1 downTo startR + 1) {
                circle.add(board[i][startC])
            }

            // 회전
            circle.add(0, circle.removeLast())
            answer.add(circle.minOf { it })

            for (i in startC..endC) {
                board[startR][i] = circle.removeFirst()
            }
            for (i in startR + 1..endR) {
                board[i][endC] = circle.removeFirst()
            }
            for (i in endC - 1 downTo startC) {
                board[endR][i] = circle.removeFirst()
            }
            for (i in endR - 1 downTo startR + 1) {
                board[i][startC] = circle.removeFirst()
            }
        }

        return answer.toIntArray()
    }
}