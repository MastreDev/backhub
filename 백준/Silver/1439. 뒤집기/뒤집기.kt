fun main() {
    val s = readln().toCharArray().map(Char::digitToInt)
    var cnt = 0
    s.zipWithNext { a, b -> if (a != b) cnt++ }
    val result = cnt / 2.0f
    println(Math.round(result))
}