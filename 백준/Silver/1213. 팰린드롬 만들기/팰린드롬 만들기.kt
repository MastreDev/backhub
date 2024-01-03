import java.util.Stack

fun main() {
    val chars = readln()
    val length = chars.length
    val charMap = chars.groupingBy { it }.eachCount().toMutableMap()
    if (charMap.values.count { it % 2 == 1 } > 1) return println("I'm Sorry Hansoo")

    val resultChars = CharArray(length) { '*' }

    if (length % 2 == 0) {
        //even
        var start = 0
        var end = length - 1
        val stack = chars.toList().sortedDescending().toCollection(Stack())
        while (stack.isNotEmpty() && start < end) {
            resultChars[start] = stack.pop()
            resultChars[end] = stack.pop()
            start++
            end--
        }
    } else {
        //odd
        val middle = length / 2
        var start = 0
        var end = length - 1
        val center = charMap.entries.first { it.value % 2 == 1 }
        resultChars[middle] = center.key
        charMap.compute(center.key) { _, value -> value?.minus(1) }
        val stack = charMap.entries.sortedByDescending { it.key }.map { entry -> List(entry.value) { entry.key } }.flatten().toCollection(Stack())

        while (stack.isNotEmpty() && start < end) {
            resultChars[start] = stack.pop()
            resultChars[end] = stack.pop()
            start++
            end--
        }
    }
    println(resultChars)
}