class Solution {
    fun solution(my_string: String): Int {
        val numberRange = '0'.toInt() .. '9'.toInt()
        return my_string.filter{ it.toInt() in numberRange }.map{ it.digitToInt() }.sum()
    }
}