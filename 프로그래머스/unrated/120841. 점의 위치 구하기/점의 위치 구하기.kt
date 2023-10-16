class Solution {
    fun solution(dot: IntArray): Int {
        val multiple = dot[0] * dot[1]
        return when {
            multiple > 0 && dot[0] > 0 -> 1
            multiple > 0 && dot[0] < 0 -> 3
            multiple < 0 && dot[0] > 0 -> 4
            multiple < 0 && dot[0] < 0 -> 2
            else -> -1
        }
    }
}