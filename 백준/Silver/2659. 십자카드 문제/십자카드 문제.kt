private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    // 같은 숫자 존재 가능
    // 숫자는 1111 - 9999
    val numbers = br.readLine().split(" ").joinToString("")
    br.close()
    val clockNumber = numbers.makeClockNumber()

    var count = 0
    for (i in 1111 until 10000) {
        if ('0' in i.toString()) continue
        if (i.makeClockNumber() != i) continue
        if (clockNumber == i) {
            bw.write(count.plus(1).toString())
            break
        }
        count++
    }
    bw.close()
}

private fun String.makeClockNumber(): Int {
    var min = 10000
    repeat(4) {
        val candidate = this.takeLast(4 - it) + this.take(it)
        min = minOf(min, candidate.toInt())
    }
    return min
}

private fun Int.makeClockNumber() = this.toString().makeClockNumber()