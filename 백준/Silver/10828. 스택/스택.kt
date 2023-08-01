import java.util.Stack

fun main() {
    val commandCnt = readln().toInt()
    val commands = Array(commandCnt) {
        val readLine = readln().split(' ')
        val exec = readLine.first()
        val option = readLine.getOrNull(1)?.toInt()
        exec to option
    }
    val stack = Stack<String>()
    commands
        .map {
            val (exec, option) = it
            when (exec) {
                "push" -> stack.push(option!!.toString()).run { "" }
                "pop" -> if (stack.isEmpty()) "-1" else stack.pop()
                "size" -> stack.size.toString()
                "empty" -> if (stack.isEmpty()) 1.toString() else 0.toString()
                "top" -> if (stack.isEmpty()) (-1).toString() else stack.peek()
                else -> ""
            }
        }
        .filter { it != "" }
        .joinToString("\n")
        .also { println(it) }
}