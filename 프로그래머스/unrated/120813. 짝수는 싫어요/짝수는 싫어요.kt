class Solution {
    fun solution(n: Int): IntArray {
        return (1 .. n step 2).toList().toIntArray()
    }
}