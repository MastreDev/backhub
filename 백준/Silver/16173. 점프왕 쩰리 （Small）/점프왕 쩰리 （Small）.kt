import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val array = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
    var arrive = false

    fun doBfs() {
        val dx = arrayOf(1, 0)
        val dy = arrayOf(0, 1)
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(0 to 0)

        while (queue.isNotEmpty()) {
            val (row, col) = queue.poll()!!
            val weight = array[row][col]
            if (weight == 0) break
            if (weight == -1) {
                arrive = true
                break
            }

            for (i in 0 until 2) {
                val dr = row + dy[i] * weight
                val dc = col + dx[i] * weight
                if (dr !in 0 until n || dc !in 0 until n) continue
                queue.offer(dr to dc)
            }
        }
    }
    doBfs()

    println("HaruHaru".takeIf { arrive } ?: "Hing")
}