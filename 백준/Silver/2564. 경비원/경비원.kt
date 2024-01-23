fun main() {
    val (c, r) = readln().split(" ").map(String::toInt)
    val length = (c + r) * 2
    //1 N, 2 S, 3 W, 4 E
    val flat = IntArray(length)
    val offsets = arrayOf(0, c + r, c + r + c, c)
    val storeCount = readln().toInt()
    repeat(storeCount) {
        var (d, v) = readln().split(" ").map(String::toInt)
        if (d == 2) v = c - v
        if (d == 3) v = r - v
        flat[offsets[d - 1] + v] = it + 1
    }

    var (d, v) = readln().split(" ").map(String::toInt)
    if (d == 2) v = c - v
    if (d == 3) v = r - v
    val dongIndex = offsets[d - 1] + v
    flat[dongIndex] = -1

    var acc = 0

    repeat(storeCount) { x ->
        val store = flat.withIndex().first { it.value == x + 1 }.index
        val clockLength = if (dongIndex > store) dongIndex - store else store - dongIndex
        val counterClockLength = if (dongIndex > store) length - dongIndex + store else dongIndex + length - store
        acc += minOf(clockLength, counterClockLength)
    }

    println(acc)
}