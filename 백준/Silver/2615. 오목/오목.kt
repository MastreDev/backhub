fun main() {
    //size 19 * 19
    // 여섯알 이상 놓인 경우는 이긴것이 아니다 Length == 5
    // 이기는 경우는 한번만 있으므로, 케이스를 찾으면 즉시 멈추면 된다.
    // 검은색은 1, 흰색은 2 빈칸은 0
    val board = Array(19) {
        readln().split(" ").map(String::toInt).toIntArray()
    }
    val range = 0 until 19
    // rt, r, rb, b
    // reverse ->
    val dx = arrayOf(1, 1, 1, 0, -1, -1, -1, 0) // direction + 4 하면 reverse
    val dy = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1) // direction + 4 하면 reverse

    fun scanDirections(row: Int, col: Int, keyStone: Int): Boolean {
        for (i in 0 until 4) {
            var nR = row
            var nC = col
            var forwardCount = 1
            while (true) {
                nR += dy[i]
                nC += dx[i]
                if (nR !in range || nC !in range) break
                if (keyStone != board[nR][nC]) break
                forwardCount++
            }

            var rr = row
            var rc = col
            var backwardCount = 0
            while (true) {
                rr += dy[i + 4]
                rc += dx[i + 4]
                if (rr !in range || rc !in range) break
                if (keyStone != board[rr][rc]) break
                backwardCount++
            }

            if (forwardCount == 5 && backwardCount == 0) return true
        }
        return false
    }

    for (i in range) {
        for (j in range) {
            val keyStone = board[i][j]
            if (keyStone == 0) continue
            val found = scanDirections(i, j, keyStone)
            if (found) {
                println("$keyStone\n${i + 1} ${j + 1}")
                return
            }
        }
    }
    println(0)
}