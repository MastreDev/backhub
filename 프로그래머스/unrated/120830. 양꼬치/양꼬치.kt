class Solution {
    fun solution(n: Int, k: Int): Int {
        return (n * 12000) + ((k - n / 10) * 2000)
    }
}