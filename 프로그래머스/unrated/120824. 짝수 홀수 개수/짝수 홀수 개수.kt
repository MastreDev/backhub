class Solution {
    fun solution(num_list: IntArray): IntArray {
        val evenCount = num_list.count{it % 2 == 0}
        return intArrayOf(evenCount, num_list.count() - evenCount)
    }
}