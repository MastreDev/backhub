class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var sum = 0
        var i = 0
        while(sum <= n) {
            sum += numbers[i]
            i++
        }
        return sum
    }
}