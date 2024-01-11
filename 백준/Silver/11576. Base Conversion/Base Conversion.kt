import kotlin.math.pow

fun main() {
    val (a, b) = readln().split(" ").map(String::toInt)
    val count = readln().toInt()
    val array = readln().split(" ").map(String::toInt)

    //a converse to b
    val aDouble = a.toDouble()
    val targetTen = array.reversed().foldIndexed(0) { index, acc, i -> aDouble.pow(index).toInt().times(i) + acc }

    var temp = targetTen
    val results = mutableListOf<Int>()
    while (b <= temp) {
        results.add(temp % b)
        temp /= b
    }

    println("$temp ${results.reversed().joinToString(" ")}")

}