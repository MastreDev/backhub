import java.util.Stack

fun main() {
    val n = readln().toInt()
    var stack: Stack<Char>

    val results = arrayListOf<String>()

    repeat(n) {
        stack = Stack<Char>()
        val tc = readln().toCharArray()
        tc.forEach {
            if (it == '(')
                stack.push(it)

            if (it == ')') {
                if (stack.isEmpty()) {
                    results.add("NO")
                    return@repeat
                }
                if (stack.isNotEmpty())
                    stack.pop()
            }
        }
        results.add("YES".takeIf { stack.isEmpty() } ?: "NO")
    }
    results.forEach { println(it) }
}