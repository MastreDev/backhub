class Solution {
    fun solution(angle: Int): Int {
        return when(angle) {
            in 0 until 90 -> 1
            90 -> 2
            in 90 until 180 -> 3
            180 -> 4
            else -> 5
        }
    }
}