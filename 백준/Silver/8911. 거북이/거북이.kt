import java.util.LinkedList
import kotlin.math.absoluteValue

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        bw.write("${Turtle(br.readLine()).simulate()}\n")
    }
    bw.close()
    br.close()
}

class Turtle(private val orders: String) {
    private var direction = 0
    private val current = arrayOf(0, 0)
    private val commands = orders.toCollection(LinkedList())
    private val widths = arrayOf(0, 0)
    private val heights = arrayOf(0, 0)

    fun simulate(): Int {
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