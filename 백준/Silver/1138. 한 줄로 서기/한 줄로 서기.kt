fun main() {
    val n = readln().toInt()
    val checks = readln().split(" ").map(String::toInt).toIntArray()
    val results = IntArray(n) { -1 }

    checks.forEachIndexed { index, v ->
        for (i in v until n) {
            if (results[i] > -1) continue

            var biggerCounts = 0
            for (j in 0 until i) {
                if (results[j] == -1) biggerCounts++
            }
            
            if (v - biggerCounts != 0) continue
            results[i + v - biggerCounts] = index + 1
            break
        }
    }

    println(results.joinToString(" "))

}