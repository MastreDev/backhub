class Solution {
    fun solution(my_string: String, alp: String): String {
        return my_string.map {
            if(it == alp[0]) (it.toInt() - 32).toChar() else it
        }.joinToString("")
    }
}