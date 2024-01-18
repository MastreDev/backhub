fun main() {
    var n = readln()
    var count = 0
    while (n.length > 1) {
        var sum = 0
        n.forEach { sum += it.code - 48 }
        n = sum.toString()
        count++
    }
    println("$count\n${"YES".takeIf { n.toInt() % 3 == 0 } ?: "NO"}")
}