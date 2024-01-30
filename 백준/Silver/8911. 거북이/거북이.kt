import java.util.LinkedList
import java.util.Queue
import kotlin.math.absoluteValue

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        bw.write("${simulate(br.readLine().toCollection(LinkedList()))}\n")
    }
    bw.close()
    br.close()
}

private val directions = arrayOf(
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

private fun simulate(commands: Queue<Char>): Int {
    var direction = 0
    val current = arrayOf(0, 0)
    val widths = arrayOf(0, 0)
    val heights = arrayOf(0, 0)

    while (commands.isNotEmpty()) {
        when (commands.poll()!!) {
            'F' -> {
                val dPoint = directions[direction]
                current[0] += dPoint[1][0]
                current[1] += dPoint[0][0]

                widths[0] = minOf(widths[0], current[1])
                widths[1] = maxOf(widths[1], current[1])

                heights[0] = minOf(heights[0], current[0])
                heights[1] = maxOf(heights[1], current[0])
            }

            'B' -> {
                val dPoint = directions[direction]
                current[0] += dPoint[1][1]
                current[1] += dPoint[0][1]

                widths[0] = minOf(widths[0], current[1])
                widths[1] = maxOf(widths[1], current[1])

                heights[0] = minOf(heights[0], current[0])
                heights[1] = maxOf(heights[1], current[0])
            }

            'L' -> direction = 3.takeIf { direction == 0 } ?: (direction - 1)

            'R' -> direction = 0.takeIf { direction == 3 } ?: (direction + 1)
        }
    }
    val rW = widths[1] - widths[0]
    val rH = heights[1] - heights[0]
    return rW.times(rH).absoluteValue
}