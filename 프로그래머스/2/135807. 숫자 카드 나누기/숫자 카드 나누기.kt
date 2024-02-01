class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var candiA = mutableListOf<Int>()
        (2..arrayA[0]).forEach {
            if (arrayA[0] % it == 0) candiA.add(it)
        }
        for (i in 1 until arrayA.size) {
            candiA = candiA.filter { arrayA[i] % it == 0 }.toMutableList()
        }
        for (element in arrayB) {
            candiA = candiA.filter { element % it > 0 }.toMutableList()
        }

        var candiB = mutableListOf<Int>()
        (2..arrayB[0]).forEach {
            if (arrayB[0] % it == 0) candiB.add(it)
        }
        for (i in 1 until arrayB.size) {
            candiB = candiB.filter { arrayB[i] % it == 0 }.toMutableList()
        }
        for (element in arrayA) {
            candiB = candiB.filter { element % it > 0 }.toMutableList()
        }
        return maxOf(candiA.maxOrNull() ?: 0, candiB.maxOrNull() ?: 0)
    }
}