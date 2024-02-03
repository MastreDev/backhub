import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (s, e, q) = br.readLine().split(" ")
    val joiners = mutableSetOf<String>()
    var result = 0

    val start = Time(s)
    val end = Time(e)
    val streamingEnd = Time(q)

    while (true) {
        val input = br.readLine()
        if (input == null || input.isEmpty()) break
        val split = input.split(" ")
        val time = Time(split[0])
        val id = split[1]
        if (time <= start) {
            joiners.add(id)
        } else if (end <= time && time <= streamingEnd) {
            if (joiners.remove(id)) (result++)
        }
    }
    bw.write(result.toString())
    bw.close()
    br.close()
}

private data class Time(val hour: Int, val min: Int) {

    constructor(raw: String) : this(raw.split(":")[0].toInt(), raw.split(":")[1].toInt())

    operator fun compareTo(other: Time): Int {
        if (hour < other.hour) return -1
        if (hour > other.hour) return 1
        if (min < other.min) return -1
        if (min > other.min) return 1
        return 0
    }

}