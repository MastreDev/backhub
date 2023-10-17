class Solution {
    fun solution(n: Int, control: String): Int {
        val map = hashMapOf(
            'w' to 1,
            's' to -1,
            'd' to 10,
            'a' to -10
        )
        return control.fold(n){acc, v -> 
            acc + map.getOrDefault(v, 0)
        }
    }
}