import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val entry = LinkedHashSet<String>().apply {
        repeat(n) { this.add(readln()) }
    }
    val exit = LinkedList<String>().apply {
        repeat(n) { this.add(readln()) }
    }
    var count = 0
    while (exit.isNotEmpty()) {
        val current = exit.poll()!!
        if (entry.first() != current) count++
        entry.remove(current)
    }
    println(count)
}