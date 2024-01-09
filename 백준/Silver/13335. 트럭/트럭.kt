import java.util.*

fun main() {
    val (n, w, l) = readln().split(" ").map(String::toInt)
    val trucks = readln().split(" ").map(String::toInt).toCollection(LinkedList())
    val bridge: Queue<Int> = LinkedList()
    var takenTime = 0

    while (trucks.isNotEmpty()) {
        if (bridge.size >= w) bridge.poll()!!
        bridge.add(0.takeIf{bridge.sum() + trucks.peek()!! > l} ?: trucks.poll()!!)
        takenTime++
    }

    if (bridge.isNotEmpty()) takenTime += w
    println(takenTime)
}