fun main() {
    val keys = (1..10000)
        .map { it to d(it) }
        .groupingBy { it.second }
        .eachCount()

    (1..10000)
        .filter { !keys.containsKey(it) }
        .forEach { println(it) }
}

fun d(x: Int): Int {
    return x + x.toString().toCharArray().sumOf { it.digitToInt() }
}