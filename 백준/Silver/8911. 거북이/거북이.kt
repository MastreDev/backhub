import java.util.LinkedList
import kotlin.math.absoluteValue

fun main() {
    val t = readln().toInt()
    // N 0, E 1, S 2, W 3
    val directions = arrayOf(
        arrayOf(
            arrayOf(0, 0),
            arrayOf(-1, 1)
        ),
        arrayOf(
            arrayOf(1, -1),
            arrayOf(0, 0)
        ),
        arrayOf(
            arrayOf(0, 0),
            arrayOf(1, -1)
        ),
        arrayOf(
            arrayOf(-1, 1),
            arrayOf(0, 0)
        ),
    )
    val testCases = Array(t) { readln().toCharArray() }

    repeat(t) { i ->
        var direction = 0
        val current = arrayOf(0, 0)
        val commands = testCases[i].toCollection(LinkedList())
        val footPrint = mutableListOf(0 to 0)
        while (commands.isNotEmpty()) {
            val command = commands.poll()!!
            when (command) {
                'F' -> {
                    val dPoint = directions[direction]
                    current[0] += dPoint[1][0]
                    current[1] += dPoint[0][0]
                    footPrint.add(current[0] to current[1])
                }

                'B' -> {
                    val dPoint = directions[direction]
                    current[0] += dPoint[1][1]
                    current[1] += dPoint[0][1]
                    footPrint.add(current[0] to current[1])
                }

                'L' -> direction = 3.takeIf { direction == 0 } ?: (direction - 1)

                'R' -> direction = 0.takeIf { direction == 3 } ?: (direction + 1)
            }
        }
        val maxWidth = footPrint.maxOf { it.second }
        val minWidth = footPrint.minOf { it.second }

        val maxHeight = footPrint.maxOf { it.first }
        val minHeight = footPrint.minOf { it.first }

        val rW = maxWidth - minWidth
        val rH = maxHeight - minHeight
        println(rW.times(rH).absoluteValue)
    }
}