fun main() {
    val n = readln().toInt()
    val joiners = Array(n) {
        // nation, student number, point
        readln().split(" ").map(String::toInt).toIntArray()
    }
    joiners.sortByDescending { it[2] }

    val results = mutableListOf<IntArray>()

    for (i in joiners.indices) {
        val student = joiners[i]
        val national = student[0]
        if (results.count { national == it[0] } < 2) results.add(student)
        if (results.size == 3) break
    }

    results.map { "${it[0]} ${it[1]}" }.forEach { println(it) }
}