class Solution {
    fun solution(num_list: IntArray): IntArray {
        return num_list.indices.reversed().map{num_list[it]}.toIntArray()
    }
}