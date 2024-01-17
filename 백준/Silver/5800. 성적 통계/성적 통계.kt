fun main() {
    val n = readln().toInt()
    val results = StringBuilder()
    repeat(n) {
        results.appendLine("Class ${it + 1}")
        val grades = readln().split(" ").map(String::toInt).drop(1).sorted()
        val min = grades.first()
        val max = grades.last()
        var largeGap = 0
        grades.zipWithNext { a, b -> largeGap = maxOf(largeGap, b - a) }
        results.appendLine("Max $max, Min $min, Largest gap $largeGap")
    }
    print(results.toString())
}