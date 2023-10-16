class Solution {
    fun solution(my_string: String): String {
        return my_string.indices.reversed().map{my_string[it]}.joinToString("")
    }
}