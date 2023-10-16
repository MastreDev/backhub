class Solution {
    fun solution(num1: Int, num2: Int): Int {
        return 1.takeIf{num1 == num2} ?: -1
    }
}