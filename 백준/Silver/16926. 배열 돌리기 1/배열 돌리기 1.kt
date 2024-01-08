import java.util.LinkedList

fun main() {
    val (n, m, r) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
    val queues = mutableListOf<LinkedList<Int>>()

    fun makeQueue(skip: Int) {
        if (queues.flatMap { it.toList() }.size == n * m) return
        val queue = LinkedList<Int>()

        for (i in skip until m - skip) {
            queue.add(board[skip][i])
        }
        for (i in skip + 1 until n - skip) {
            queue.add(board[i][m - 1 - skip])
        }
        for (i in m - skip - 2 downTo skip) {
            queue.add(board[n - 1 - skip][i])
        }
        for (i in n - skip - 2 downTo skip + 1) {
            queue.add(board[i][skip])
        }
        queues.add(queue)
        makeQueue(skip + 1)
    }

    fun reComposition() {
        queues.forEachIndexed { index, ints ->
            for (i in index until m - index) {
                board[index][i] = ints.poll()!!
            }
            for (i in index + 1 until n - index) {
                board[i][m - 1 - index] = ints.poll()!!

            }
            for (i in m - index - 2 downTo index) {
                board[n - 1 - index][i] = ints.poll()!!
            }
            for (i in n - index - 2 downTo index + 1) {
                board[i][index] = ints.poll()!!
            }
        }
    }

    fun rotate() {
        queues.forEach {
            it.addLast(it.removeFirst())
        }
    }

    makeQueue(0)

    repeat(r) { rotate() }

    reComposition()

    board.forEach { println(it.joinToString(" ")) }
}