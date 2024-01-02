fun main() {

    val n = readln().toInt()
    val map = Array(n) { readln().toCharArray() }

    fun searchRowCandies(findCandy: (Int, Int) -> Char): Int {
        var maxCandies = 0
        for (i in 0 until n) {
            var beforeCandy: Char? = null
            var seqCandies = 0
            for (j in 0 until n) {
                val currentCandy = findCandy(i, j)
                if (beforeCandy == null) {
                    beforeCandy = currentCandy
                    seqCandies = 1
                    continue
                }
                if (beforeCandy == currentCandy) {
                    seqCandies++

                } else {
                    beforeCandy = currentCandy
                    seqCandies = 1
                }
                maxCandies = maxOf(maxCandies, seqCandies)
            }
        }
        return maxCandies
    }

    val findRowCandies = { i: Int, j: Int -> map[i][j] }
    val findColCandies = { i: Int, j: Int -> map[j][i] }

    fun searchCandies(): Int {
        val rowCandies = searchRowCandies(findRowCandies)
        val colCandies = searchRowCandies(findColCandies)
        return maxOf(rowCandies, colCandies)
    }

    fun swap(from: Pair<Int, Int>, to: Pair<Int, Int>) {
        val (fromI, fromJ) = from
        val (toI, toJ) = to

        map[fromI][fromJ].also { oldFrom ->
            map[fromI][fromJ] = map[toI][toJ]
            map[toI][toJ] = oldFrom
        }
    }

    var maxCandies = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j + 1 >= n) continue
            swap(i to j, i to j + 1)
            val candidate = searchCandies()
            maxCandies = maxOf(maxCandies, candidate)
            swap(i to j, i to j + 1)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j + 1 >= n) continue
            swap(j to i, j + 1 to i)
            val candidate = searchCandies()
            maxCandies = maxOf(maxCandies, candidate)
            swap(j to i, j + 1 to i)
        }
    }

    println(maxCandies)

}