class Solution {
    fun solution(n: Int, control: String): Int {
        return control.fold(n){acc, v -> 
            acc + when(v) {
                'w' -> 1
                's' -> -1
                'd' -> 10
                'a' -> -10
                else -> 0
            }
        }
    }
}