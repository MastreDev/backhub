private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    // 같은 숫자 존재 가능
    // 숫자는 1111 - 9999
    val numbers = br.readLine().split(" ").joinToString("")
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
    br.close()
    bw.close()
}

private fun String.makeClockNumber(): Int {
    val candidates = mutableListOf<Int>()
    repeat(4) {
        val candidate = this.takeLast(4 - it) + this.take(it)
        candidates.add(candidate.toInt())
    }
    return candidates.min()
}

private fun Int.makeClockNumber() = this.toString().makeClockNumber()