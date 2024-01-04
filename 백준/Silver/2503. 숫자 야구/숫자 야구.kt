fun main() {

    fun Int.split(): List<Int> = this.toString().map(Char::digitToInt)

    val n = readln().toInt()
    val clues = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }

    val use = BooleanArray(10)
    val candidates = mutableListOf<IntArray>()

    fun makePossibleNumber(index: Int, container: IntArray) {
        if (index == container.size) {
            candidates.add(container.copyOf())
            return
        }

        (1 until 10).forEach {
            if (!use[it]) {
                use[it] = true
                container[index] = it
                makePossibleNumber(index + 1, container)
                use[it] = false
            }
        }
    }

    makePossibleNumber(0, IntArray(3))

    val results = mutableListOf<IntArray>() // for debug

    loopCandidate@ for (i in candidates.indices) {
        val candidate = candidates[i]

        for (j in clues.indices) {
            val clue = clues[j]
            val guessNumber = clue[0].split()
            var strikeCount = 0
            var ballCount = 0

            repeat(3) {
                when (guessNumber[it]) {
                    candidate[it] -> strikeCount++
                    in candidate -> ballCount++
                }
            }

            if (strikeCount != clue[1] || ballCount != clue[2]) continue@loopCandidate
        }

        results.add(candidate)
    }

    println(results.size)

}