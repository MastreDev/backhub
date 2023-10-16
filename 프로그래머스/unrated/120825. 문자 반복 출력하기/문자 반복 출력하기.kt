class Solution {
    fun solution(my_string: String, n: Int): String {
        return my_string.map{ char -> StringBuilder().apply{repeat(n){this.append(char)}}}.joinToString("")
    }
}