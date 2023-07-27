fun main() {
    readln().uppercase()
        .groupingBy { it }
        .eachCount()
        .entries
        .groupBy({ it.value }, { it.key })
        .entries.maxByOrNull { it.key }!!
        .run { if (value.size > 1) '?' else value.first() }
        .also { println(it) }
} 