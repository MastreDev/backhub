class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val dest = num_list.size
        return (0 until dest step n).map{ num_list[it] }.toIntArray()
    }
}