import java.util.LinkedList

fun main() {
    data class Vector(val direction: Int, val value: Int) {
        val isHeight get() = direction == 3 || direction == 4
        val isWidth get() = direction == 1 || direction == 2
    }

    val melons = readln().toInt()
    val sides = LinkedList<Vector>().apply {
        repeat(6) {
            readln().split(" ").map(String::toInt).also {
                this.offer(Vector(it[0], it[1]))
            }
        }
    }
    val whatNext = arrayOf(-1, 4, 3, 1, 2)

    val maxWidth = sides.filter { it.isWidth }.maxOf { it.value }
    val maxHeight = sides.filter { it.isHeight }.maxOf { it.value }

    var minusArea = 0

    while (sides.isNotEmpty()) {
        val current = sides.poll()!!
        val expectedNext = whatNext[current.direction]
        if (expectedNext != sides.peek()?.direction) {
            val unexpected = sides.poll()!!
            minusArea = current.value * unexpected.value
            break
        } else {
            sides.offer(current)
        }
    }

    println(maxWidth.times(maxHeight).minus(minusArea).times(melons))
}