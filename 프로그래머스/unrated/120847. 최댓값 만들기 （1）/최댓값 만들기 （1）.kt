class Solution {
    fun solution(numbers: IntArray): Int {
        return numbers.sortedDescending().take(2).reduce{acc, v -> acc * v}
    }
}