fun main() {
    val n = readln().toInt()
    var dasom = readln().toInt()
    val others = IntArray(n - 1) { readln().toInt() }
    val bigManIndex = others.lastIndex
    var count = 0

    while (others.isNotEmpty()) {
        others.sort()
        if (dasom > others[bigManIndex]) break
        dasom++
        others[bigManIndex]--
        count++
    }

    println(count)

}