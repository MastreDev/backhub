import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.sqrt

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
    val n = br.readLine().toInt()
    Array(n) {
        val input = br.readLine().split(" ").map(String::toInt)
        val a = arrayOf(input[0], input[1], input[2])
        val b = arrayOf(input[3], input[4], input[5])
        val distance = a[2].toDouble() + b[2]
        val ttt = sqrt(a[0].toDouble().minus(b[0]).pow(2).plus(a[1].toDouble().minus(b[1]).pow(2)))
        when {
            a.contentEquals(b) -> bw.write("-1")
            // a > b
            ttt + b[2] < a[2] -> bw.write("0")
            // a < b
            ttt + a[2] < b[2] -> bw.write("0")
            ttt + a[2] == b[2].toDouble() -> bw.write("1")
            ttt + b[2] == a[2].toDouble() -> bw.write("1")
            // ap == bp
            ttt == 0.0 && a[2] != b[2] -> bw.write("0")
            ttt == 0.0 && a[2] == b[2] -> bw.write("-1")
            // 외부
            ttt > distance -> bw.write("0")
            ttt < distance -> bw.write("2")
            ttt == distance -> bw.write("1")
            else -> bw.write("0")


        }
        bw.newLine()
    }
    br.close()
    bw.close()
}