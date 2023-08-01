import java.util.Stack

fun main(){
    val k = readln().toInt()
    val stack = Stack<Int>()
    repeat(k) {
        val input = readln().toInt()
        if(input == 0) {
            stack.pop()
        } else {
            stack.push(input)
        }
    }
    println(stack.sum())
}