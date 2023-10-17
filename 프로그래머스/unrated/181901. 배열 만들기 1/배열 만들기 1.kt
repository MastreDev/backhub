class Solution {
    fun solution(n: Int, k: Int): IntArray {
        return (k..n step k).toList().toIntArray()
    }
}