fun main() {
    val n = readln().toInt()

    var maxNumber = 0
    fun doRecursive(depth: Int, index: Int, numbers: IntArray, con: IntArray) {
        if (depth == 3) {
            maxNumber = maxOf(maxNumber, con.sum() % 10)
            return
        }

        for (i in index until numbers.size) {
            con[depth] = numbers[i]
            doRecursive(depth + 1, i + 1, numbers, con)
        }
    }

    var winNumber = 0
    var winSum = 0
    repeat(n) {
        maxNumber = 0
        val p = readln().split(" ").map(String::toInt).toIntArray()
        doRecursive(0, 0, p, IntArray(3))
        winSum = maxOf(winSum, maxNumber)
        if (winSum == maxNumber) winNumber = it + 1
    }

    println(winNumber)

}