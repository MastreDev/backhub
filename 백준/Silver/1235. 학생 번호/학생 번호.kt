fun main() {
    val n = readln().toInt()
    val students = Array(n) { readln().toList() }
    val length = students.first().size
    val sets = hashSetOf<String>()
    var result = 0

    outer@ for (i in 1..length) {
        sets.clear()
        for (j in students.indices) {
            val isDup = !sets.add(students[j].takeLast(i).joinToString(""))
            if (isDup) continue@outer
        }
        result = i
        break
    }

    println(result)
}