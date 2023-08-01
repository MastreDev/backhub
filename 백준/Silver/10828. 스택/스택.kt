import java.util.LinkedList

fun main() {
    val commandCnt = readln().toInt()
    val commands = Array(commandCnt) {
        val readLine = readln().split(' ')
        val exec = readLine.first()
        val option = readLine.getOrNull(1)?.toInt()
        exec to option
    }
    val stack = LinkedList<String>()

    commands.forEach {
        val (exec, option) = it
        when(exec) {
            "push" -> stack.addLast(option!!.toString())
            "pop" -> {
                if(stack.isEmpty())
                    println(-1)
                else {
                    println(stack.removeLast())
                }
            }
            "size" -> println(stack.size)
            "empty" -> {
                if(stack.isEmpty())
                    println(1)
                else
                    println(0)
            }
            "top" -> {
                if(stack.isEmpty())
                    println(-1)
                else
                    println(stack.last)
            }
        }
    }
}