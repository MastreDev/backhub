fun main() {
    val n = readln()
    var conversion = n
    var count = 0
    while (conversion.length > 1) {
        conversion = conversion.toList().map(Char::digitToInt).sum().toString()
        count++
    }
    println("$count\n${"YES".takeIf { conversion.toInt() % 3 == 0 } ?: "NO"}")
}