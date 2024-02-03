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

    val start = s.toSeconds()
    val end = e.toSeconds()
    val streamingEnd = q.toSeconds()

    while (true) {
        val input = br.readLine()
        if (input == null || input.isEmpty()) break
        val split = input.split(" ")
        val time = split[0].toSeconds()
        val id = split[1]
        if (time <= start) {
            joiners.add(id)
        } else if (time in end..streamingEnd) {
            if (joiners.remove(id)) (result++)
        }
    }
    bw.write(result.toString())
    bw.close()
    br.close()
}

private fun String.toSeconds(): Int {
    return this.split(":").map(String::toInt).run { this[0] * 60 + this[1] }
}