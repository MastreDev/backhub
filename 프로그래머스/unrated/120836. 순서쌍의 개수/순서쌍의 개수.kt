class Solution {
    fun solution(n: Int): Int {
        return (1..n).count{ n % it == 0}
    }
}