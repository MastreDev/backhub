fun main() {
    val n = readln().toInt()
    val romes = intArrayOf(1, 5, 10, 50)
    val results = hashSetOf<Int>()

    fun makeNumber(depth: Int, cursor: Int, container: IntArray) {
        if (depth == n) {
            results.add(container.sum())
            return
        }
        for (i in cursor until 4) {
            container[depth] = romes[i]
            makeNumber(depth + 1, i, container)
        }
    }
    makeNumber(0, 0, IntArray(n))
    println(results.size)
}