import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, w, l) = readln().split(" ").map(String::toInt)
    val trucks = readln().split(" ").map(String::toInt).toCollection(LinkedList())
    val bridge: Queue<Int> = LinkedList()
    var takenTime = 0

    while (trucks.isNotEmpty()) {
        if (bridge.size >= w) bridge.poll()!!
        if (bridge.sum() + trucks.peek()!! <= l) {
            bridge.add(trucks.poll()!!)
        } else {
            bridge.add(0)
        }

        takenTime++
    }

    if (bridge.isNotEmpty()) takenTime += w
    println(takenTime)
}