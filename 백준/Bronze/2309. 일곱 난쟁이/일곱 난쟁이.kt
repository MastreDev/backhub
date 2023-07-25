fun main() {
    val totalHeight = 100
    val dwarfs = 9
    val heights = IntArray(dwarfs)

    repeat(dwarfs) {
        heights[it] = readln().toInt()
    }

    heights.sort()
    val sumHeights = heights.sum()

    all@ for (i in 0 until dwarfs - 1) {
        for (j in i + 1 until dwarfs) {
            val minus = heights[i] + heights[j]
            if (sumHeights - minus == totalHeight) {
                heights[i] = -1
                heights[j] = -1
                heights.filter { it != -1 }.forEach { println(it) }
                break@all
            }
        }
    }
}