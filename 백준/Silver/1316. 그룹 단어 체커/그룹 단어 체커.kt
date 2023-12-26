import java.util.Stack

fun main() {
    val n = readln().toInt()
    val args = Array(n) { readln() }
    val count = args.count { word ->
        val set = HashSet<Char>()
        val stack = Stack<Char>()
        word.forEach {
            if(!set.add(it) && (stack.isNotEmpty() && stack.peek() != it)) return@count false
            stack.push(it)
        }
        true
    }
    println(count.toString())
}