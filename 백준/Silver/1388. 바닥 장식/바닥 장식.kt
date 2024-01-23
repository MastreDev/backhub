import java.util.Stack

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val floor = Array(n) { readln().toCharArray() }
    var woods = 0
    val stack = Stack<Char>()

    for (i in 0 until n) {
        stack.clear()
        for (j in 0 until m) {
            val currentWood = floor[i][j]
            if (currentWood.direction == 1) {
                stack.clear()
                continue
            }
            if (stack.isEmpty() && currentWood.direction == 0) {
                stack.push(currentWood)
                woods++
                continue
            }
            val lastDirection = stack.peek().direction
            if (lastDirection == currentWood.direction) {
                stack.push(currentWood)
                continue
            }
        }
    }

    for (j in 0 until m) {
        stack.clear()
        for (i in 0 until n) {
            val currentWood = floor[i][j]
            if (currentWood.direction == 0) {
                stack.clear()
                continue
            }
            if (stack.isEmpty() && currentWood.direction == 1) {
                stack.push(currentWood)
                woods++
                continue
            }
            val lastDirection = stack.peek().direction
            if (lastDirection == currentWood.direction) {
                stack.push(currentWood)
                continue
            }
        }
    }
    println(woods)
}

private val Char.direction get() = 1.takeIf { this == '|' } ?: 0