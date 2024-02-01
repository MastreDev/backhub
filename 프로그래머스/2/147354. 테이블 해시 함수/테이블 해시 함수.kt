class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val sorted = data.sortedWith { a, other ->
            val aCol = a[col - 1]
            val oCol = other[col - 1]
            if (aCol < oCol) return@sortedWith -1
            if (aCol > oCol) return@sortedWith 1
            val aP = a[0]
            val oP = other[0]
            if (aP > oP) return@sortedWith -1
            if (aP < oP) return@sortedWith 1
            0
        }
        val result = (row_begin..row_end).fold(0) { acc, i ->
            val sI = sorted[i - 1].fold(0) { z, n -> z + n % i }
            acc xor sI
        }
        return result
    }
}