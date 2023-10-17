class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        return my_strings.mapIndexed{ index, v -> 
            val part = parts[index]
            v.take(part[1] + 1).drop(part[0])
        }.joinToString("")
    }
}