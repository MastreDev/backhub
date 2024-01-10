import java.util.Stack

fun main() {
    val n = readln().toInt()
    val array = readln().split(" ").map(String::toInt)
    val incStack = Stack<Int>()
    val decStack = Stack<Int>()
    var maxSequenceSize = 0

    for (i in array.indices) {
        val number = array[i]
        if (incStack.isEmpty()) {
            incStack.add(number)
            if (decStack.isEmpty()) decStack.add(number)
            maxSequenceSize = maxOf(maxSequenceSize, maxOf(incStack.size, decStack.size))
            continue
        }
        if (array[i - 1] <= number) {
            incStack.add(number)
            if (array[i - 1] < number) decStack.clear()
            decStack.add(number)
            maxSequenceSize = maxOf(maxSequenceSize, maxOf(incStack.size, decStack.size))
            continue
        }

        if (array[i - 1] >= number) {
            decStack.add(number)
            if (array[i - 1] > number) incStack.clear()
            incStack.add(number)
            maxSequenceSize = maxOf(maxSequenceSize, maxOf(incStack.size, decStack.size))
            continue
        }
    }
    println(maxSequenceSize)
}