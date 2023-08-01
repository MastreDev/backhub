import java.util.Stack

fun main() {
    val s = readln()
    val commandCount = readln().toInt()

    val editingText = Stack<Char>().apply { addAll(s.toList()) }
    val tempText = Stack<Char>()

    repeat(commandCount) {
        var exec = ' '
        var option = ' '
        readln().toCharArray().let { c ->
            exec = c.first()
            option = c.last()
        }
        when (exec) {
            'L' -> if(editingText.isNotEmpty()) tempText.push(editingText.pop())
            'D' -> if(tempText.isNotEmpty()) editingText.push(tempText.pop())
            'B' -> if(editingText.isNotEmpty()) editingText.pop()
            'P' -> editingText.push(option)
            else -> {}
        }
    }
    editingText.addAll(tempText.asReversed())
    println(editingText.joinToString(""))
}