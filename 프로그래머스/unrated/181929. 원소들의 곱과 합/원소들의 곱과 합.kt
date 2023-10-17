class Solution {
    fun solution(num_list: IntArray): Int {
        return 1.takeIf{
            val multiplies = num_list.reduce {acc, v -> acc * v}
            val sumPow = Math.pow(num_list.sum().toDouble(), 2.0).toInt()
            multiplies < sumPow
        } ?: 0
    }
}