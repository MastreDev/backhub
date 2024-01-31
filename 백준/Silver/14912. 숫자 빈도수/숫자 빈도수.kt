import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (n, f) = br.readLine().split(" ").map(String::toInt)
    val charF = f.digitToChar()
    var frequency = 0
    (1..n).forEach {
        it.toString().toCharArray().forEach {
            if (charF == it) frequency++
        }
    }
    println(frequency)
}