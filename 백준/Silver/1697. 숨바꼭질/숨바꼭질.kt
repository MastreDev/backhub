import java.util.LinkedList

fun main() {
    val (n, k) = readln().split(' ').map(String::toInt)
    val dist = IntArray(100_001)
    val queue = LinkedList<Int>()
    queue.offer(n)

    while (queue.isNotEmpty()) {
        val current = queue.poll()!!
        if (current == k) break

        val next = current + 1
        val before = current - 1
        val jump = current * 2

        val range = 0..100_000

        if (next in range && dist[next] == 0) {
            queue.offer(next)
            dist[next] = dist[current] + 1
        }

        if (before in range && dist[before] == 0) {
            queue.offer(before)
            dist[before] = dist[current] + 1
        }

        if (jump in range && dist[jump] == 0) {
            queue.offer(jump)
            dist[jump] = dist[current] + 1
        }
    }
    println(dist[k])
}