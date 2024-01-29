fun main() {
    // card, red, blue, yellow, green
    // each colors, 1 - 9 (9ea)
    // total 36ea

    // Rule
    val cards = Array(5) { readln().run { this[0] to this[2].digitToInt() } }
    val maxNumber = cards.maxOf { it.second }
    val minNumber = cards.minOf { it.second }

    val colorBy = cards.groupBy { it.first }
    val numberCountBy = cards.groupingBy { it.second }.eachCount().entries.groupBy { it.value }

    val isSameColor = colorBy.keys.size == 1
    val isSeq = cards.sortedBy { it.second }.map { it.second } == List(5) { it + minNumber }

    var maxPoint = 0
    // 1
    if (isSameColor && isSeq) maxPoint = maxOf(maxPoint, maxNumber + 900)
    // 2
    numberCountBy[4]?.let {
        maxPoint = maxOf(maxPoint, it.first().key + 800)
    }
    // 3
    if (numberCountBy[3]?.size == 1 && numberCountBy[2]?.size == 1) {
        maxPoint = maxOf(maxPoint, numberCountBy[3]!!.first().key * 10 + numberCountBy[2]!!.first().key + 700)
    }
    // 4
    if (isSameColor) maxPoint = maxOf(maxPoint, maxNumber + 600)

    // 5
    if (isSeq) maxPoint = maxOf(maxPoint, maxNumber + 500)

    // 6
    if (numberCountBy[3]?.size == 1) {
        maxPoint = maxOf(maxPoint, numberCountBy[3]!!.first().key + 400)
    }

    //7
    if (numberCountBy[2]?.size == 2) {
        val max = maxOf(numberCountBy[2]!![0].key, numberCountBy[2]!![1].key)
        val min = minOf(numberCountBy[2]!![0].key, numberCountBy[2]!![1].key)
        maxPoint = maxOf(maxPoint, max * 10 + min + 300)
    }

    // 8
    if (numberCountBy[2]?.size == 1) {
        maxPoint = maxOf(maxPoint, numberCountBy[2]!![0].key + 200)
    }

    maxPoint = maxOf(maxPoint, maxNumber + 100)

    println(maxPoint)
}