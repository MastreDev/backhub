import java.util.LinkedList

fun main() {
    // 왼쪽 하단이 (1,1) 이다.
    // 시계 방향 -> 달팽이
    val (c, r) = readln().split(" ").map(String::toInt)
    val board = Array(r) { BooleanArray(c) }
    val waitingTicket = readln().toInt()
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(-1, 0, 1, 0)
    val results = mutableListOf<Pair<Int, Int>>()

    if( waitingTicket > c * r) {
        println(0)
        return
    }

    fun doBfs(row: Int, col: Int) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(row to col)
        board[row][col] = true
        results.add(row to col)
        var direction = 0
        var audience = 1

        while (queue.isNotEmpty() && audience < waitingTicket) {
            val (cRow, cCol) = queue.poll()!!
            for (d in 0 until 3) {
                val newDirection = (direction + d) % 4
                val dr = cRow + dy[newDirection]
                val dc = cCol + dx[newDirection]
                if (dr !in 0 until r || dc !in 0 until c) continue
                if (board[dr][dc]) continue

                board[dr][dc] = true
                direction = newDirection
                results.add(dr to dc)
                audience++
                queue.offer(dr to dc)
                break
            }
        }
    }

    doBfs(r - 1, 0)
    val target = results[waitingTicket - 1]
    println("${target.second + 1} ${r - target.first}")
}