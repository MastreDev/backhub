class Solution {
    fun solution(sides: IntArray): Int {
        val max = sides.maxOf{ it }
        val sum = sides.sum() - max
        return 1.takeIf{ max < sum } ?: 2
    }
}