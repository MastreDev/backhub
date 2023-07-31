fun main() {
    val n = readln().toInt()
    val array = IntArray(n)
    repeat(n) {
        array[it] = readln().toInt()
    }

    for (i in 1 until n) {
        val current = array[i]
        for(j in i - 1 downTo 0) {
            val target = array[j]
            if(target > current) {
                array[j + 1] = target
                array[j] = current
            }
        }
    }
    array.forEach { println(it) }
}