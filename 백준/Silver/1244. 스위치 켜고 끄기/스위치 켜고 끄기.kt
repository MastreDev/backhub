import java.util.LinkedList
import java.util.Queue

fun main() {
    fun Int.switch(): Int {
        return 1.takeIf { this == 0 } ?: 0
    }

    val switchCount = readln().toInt()
    val switchStates = readln().split(" ").map(String::toInt).toIntArray()
    val studentCounts = readln().toInt()
    val students: Queue<IntArray> = LinkedList<IntArray>().apply {
        repeat(studentCounts) {
            this.add(readln().split(" ").map(String::toInt).toIntArray())
        }
    }

    fun switchOnMen(switchNumber: Int) {
        val div = switchCount / switchNumber
        (1..div).forEach {
            val old = switchStates[it * switchNumber - 1]
            switchStates[it * switchNumber - 1] = old.switch()
        }
    }

    fun switchOnWomen(switchNumber: Int) {
        var start = switchNumber - 2
        var end = switchNumber
        switchStates[switchNumber - 1] = switchStates[switchNumber - 1].switch()

        while (true) {
            if (start < 0 || end >= switchCount) break
            val before = switchStates[start]
            val after = switchStates[end]
            if (before != after) break

            switchStates[start] = before.switch()
            switchStates[end] = after.switch()
            start--
            end++
        }
    }

    while (students.isNotEmpty()) {
        val current = students.poll()!!
        if (current[0] == 1) switchOnMen(current[1]) else switchOnWomen(current[1])
    }
    switchStates.toList().chunked(20).forEach { println(it.joinToString(" ")) }
}