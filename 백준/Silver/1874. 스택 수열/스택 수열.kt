import java.util.Stack

fun main() {
    val n = readln().toInt()
    val queue = IntArray(n) { readln().toInt() }

    val stack = Stack<Int>()
    val answer = mutableListOf<String>()
    var cursor = 0

    (1..n).forEach {
        if (it <= queue[cursor]) {
            stack.push(it)
            answer += "+"
        }
        while (stack.isNotEmpty() && stack.peek() >= queue[cursor]) {
            stack.pop()
            cursor++
            answer += "-"
        }
    }

    if (stack.isNotEmpty()) println("NO") else println(answer.joinToString("\n"))
}