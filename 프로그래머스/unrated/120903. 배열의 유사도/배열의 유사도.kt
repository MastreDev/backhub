class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        return s1.map { v ->
            s2.count{ it == v }
        }.count {
            it > 0
        }
    }
}