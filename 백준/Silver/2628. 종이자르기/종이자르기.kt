import java.util.LinkedList

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val rows = LinkedList<Pair<Int, Int>>().apply { this.offer(0 to n) }
    val cols = LinkedList<Pair<Int, Int>>().apply { this.offer(0 to m) }
    val count = readln().toInt()

    repeat(count) {
        val (side, position) = readln().split(" ").map(String::toInt)
        if (side == 0) {
            // 가로로
            val temp = LinkedList<Pair<Int, Int>>()
            while (cols.isNotEmpty()) {
                val current = cols.poll()!!
                if (position in current.first + 1 until current.second) {
                    temp.offer(current.first to position)
                    temp.offer(position to current.second)
                } else {
                    temp.offer(current)
                }
            }
            while (temp.isNotEmpty()) {
                cols.offer(temp.poll()!!)
            }

        } else {
            // 세로로
            val temp = LinkedList<Pair<Int, Int>>()
            while (rows.isNotEmpty()) {
                val current = rows.poll()!!
                if (position in current.first + 1 until current.second) {
                    temp.offer(current.first to position)
                    temp.offer(position to current.second)
                } else {
                    temp.offer(current)
                }
            }
            while (temp.isNotEmpty()) {
                rows.offer(temp.poll()!!)
            }

        }
    }
    var max = 0
    rows.forEach { row ->
        cols.forEach { col ->
            max = maxOf(max, (col.second - col.first) * (row.second - row.first))
        }
    }
    println(max)
}