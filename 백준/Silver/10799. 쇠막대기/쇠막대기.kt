import java.util.Stack

fun main() {
    val array = readln()

    var divSticks = 0
    var depth = 0
    val stack = Stack<Char>()

    array.forEachIndexed { index, c ->
        if (c == '(') {
            stack.push(c)
            depth++
        }
        if (c == ')') {
            stack.pop()
            if (array[index - 1] == '(') {
                divSticks += stack.size
            } else {
                divSticks += 1
            }
        }
    }
    println(divSticks)
}