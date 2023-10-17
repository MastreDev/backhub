class Solution {
    fun solution(my_string: String, is_prefix: String): Int {
        if(my_string.length < is_prefix.length) return 0
        return 1.takeIf{
            is_prefix.foldIndexed(true) { index, acc, v -> 
                acc && v == my_string[index]
            }
        } ?: 0
    }
}