import kotlin.math.pow

class Solution {
    
    fun solution(numbers: IntArray): String {
        return numbers
            .sortedWith{ a, b ->
                val x = "$a$b"
                val y = "$b$a"
                when{
                    x < y -> 1
                    x > y -> -1
                    else -> 0
                }
            }
            .joinToString("").takeIf{ it.first() != '0' } ?: "0"
    }
}