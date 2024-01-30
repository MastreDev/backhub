fun main() {
    val n = readln().toInt()
    val students = List(n) { readln() }
    val length = students[0].length
    val sets = mutableSetOf<String>()
    var result = 0

    outer@ for (i in 1..length) {
        sets.clear()
        for (j in students.indices) {
            val isDup = !sets.add(students[j].takeLast(i))
            if (isDup) continue@outer
        }
        result = i
        break
    }
    println(result)
}