import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val cards = readln().split(' ').map(String::toInt)
    val sums = PriorityQueue<Int>(Collections.reverseOrder())

    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                val cardSum = cards[i] + cards[j] + cards[k]
                if(cardSum <= m) sums.offer(cardSum)
            }
        }
    }
    println(sums.poll() ?: 0)
}