import kotlin.math.pow

fun main() {
    var nLength = 0
    val n = readln().also { nLength = it.length }.toInt()

    val remain = (((n + 1) - 10.0.pow(nLength - 1)) * nLength).toInt()
    var acc = 0
    (0 until (nLength - 1)).forEach {
        acc += ((10.0.pow(it + 1) - 10.0.pow(it)).toInt()) * (it + 1)
    }
    println(remain + acc)
}