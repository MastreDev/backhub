fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val range = 2..n
    val arr = IntArray(n + 1) { if (it in range) 1 else -1 }
    var seq = 0

    loop1@ while (seq < k) {
        val pIndex = arr.indexOfFirst { it != -1 }
        arr[pIndex] = -1
        if (++seq == k) {
            println(pIndex)
            break
        }

        for (i in arr.indices) {
            if (arr[i] != -1 && i % pIndex == 0) {
                if (++seq == k) {
                    println(i)
                    break@loop1
                } else {
                    arr[i] = -1
                }
            }
        }
    }
}