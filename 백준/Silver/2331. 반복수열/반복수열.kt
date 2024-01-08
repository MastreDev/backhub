import kotlin.math.pow

fun main() {
    val (n, pow) = readln().split(" ").map(String::toInt)
    val map = hashMapOf(n to 1)

    var temp = n
    while (true) {
        val next = temp.toString().map { it.digitToInt().toDouble().pow(pow) }.sum().toInt()
        val update = map.getOrDefault(next, 0) + 1
        if (update == 3) break
        map[next] = update
        temp = next
    }
    println(map.entries.count { it.value == 1 })
}