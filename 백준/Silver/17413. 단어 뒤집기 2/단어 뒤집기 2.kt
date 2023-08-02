import java.util.Stack

fun main() {
    val stack = Stack<Char>()
    val answer = StringBuilder()
    val s = readln()

    s.forEach {
        when {
            stack.isNotEmpty() && stack.peek() == '<' && it == '>' -> {
                stack.pop()
                answer.append(it)
            }
            stack.isNotEmpty() && stack.peek() == '<' -> {
                answer.append(it)
            }
            stack.isNotEmpty() && it == '<' -> {
                while (stack.isNotEmpty()) answer.append(stack.pop())
                answer.append(it)
                stack.push(it)
            }
            it == '<' -> {
                stack.push(it)
                answer.append(it)
            }
            it == ' ' -> {
                while (stack.isNotEmpty()) answer.append(stack.pop())
                answer.append(it)
            }
            else -> stack.push(it)
        }
    }
    while (stack.isNotEmpty()) {
        answer.append(stack.pop())
    }
    println(answer.toString())
}