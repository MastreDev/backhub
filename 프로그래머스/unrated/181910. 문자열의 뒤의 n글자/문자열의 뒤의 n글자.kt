class Solution {
    fun solution(my_string: String, n: Int): String {
        // return my_string.takeLast(n)
        
        val startIndex = my_string.lastIndex
        val answer = StringBuilder()
        repeat(n) {
            val current = startIndex - it
            answer.insert(0, my_string[current])
        }
        return answer.toString()
    }
}