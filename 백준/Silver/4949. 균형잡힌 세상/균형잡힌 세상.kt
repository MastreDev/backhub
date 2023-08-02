import java.util.Stack

fun main() {
    val answers = mutableListOf<String>()
    while (true) {
        val input = readln()
        if (input.first() == '.') break
        answers.add(input.getFindResult())
    }
    println(answers.joinToString("\n"))

}

private val psMap = hashMapOf('(' to ')', '[' to ']')

private fun String.getFindResult(): String {
    val stack = this.filter { it == '(' || it == ')' || it == '[' || it == ']' }.fold(Stack<Char>()) { acc, c ->
        when {
            c in psMap.keys -> acc.push(c)
            acc.isNotEmpty() && psMap[acc.peek()] == c -> acc.pop()
            else -> return "no"
        }
        acc
    }
    return if (stack.isEmpty()) "yes" else "no"
}