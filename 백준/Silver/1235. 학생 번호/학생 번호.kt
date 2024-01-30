fun main() {
    val n = readln().toInt()
    val students = Array(n) { readln().toList() }
    val length = students.first().size
    var result = 0

    outer@ for (i in 1..length) {
        val sets = mutableSetOf<String>()
        for (j in students.indices) {
            val isDup = !sets.add(students[j].takeLast(i).joinToString(""))
            if (isDup) continue@outer
        }
        result = i
        break
    }
    println(result)
}