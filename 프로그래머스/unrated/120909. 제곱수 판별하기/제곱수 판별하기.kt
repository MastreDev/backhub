class Solution {
    fun solution(n: Int): Int {
        val sqrts = Math.sqrt(n.toDouble())
        return 1.takeIf { sqrts % Math.floor(sqrts) == 0.0 } ?: 2
    }
}