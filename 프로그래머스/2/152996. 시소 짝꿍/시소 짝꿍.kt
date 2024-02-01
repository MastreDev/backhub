class Solution {
    fun solution(weights: IntArray): Long {
        var answer = 0L
        weights.sort()
        val map = hashMapOf<Double, Int>()
        weights.forEach {
            val a = it * 1.0
            val b = it * 2.0 / 3.0
            val c = it * 2.0 / 4.0
            val d = it * 3.0 / 4.0
            answer += map[a] ?: 0
            answer += map[b] ?: 0
            answer += map[c] ?: 0
            answer += map[d] ?: 0
            map[it.toDouble()] = map.getOrDefault(it.toDouble(), 0) + 1
        }
        return answer
    }
}