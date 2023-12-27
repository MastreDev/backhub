fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val circle = (1..n).toMutableList()
    var cursor = 0
    val result = mutableListOf<Int>()

    while (result.size < n) {
        var removeAt = cursor + m - 1
        val size = circle.size
        if (removeAt >= size) removeAt %= size
        circle.removeAt(removeAt).also { result.add(it) }
        cursor = removeAt
    }
    println("<${result.joinToString(", ")}>")
}