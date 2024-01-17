val directionMap = hashMapOf(
    "R" to 0,
    "L" to 1,
    "B" to 2,
    "T" to 3,
    "RT" to 4,
    "LT" to 5,
    "RB" to 6,
    "LB" to 7,
)

fun main() {
    // 8 - 1
    // A - H
    val range = 0 until 8
    val dx = arrayOf(1, -1, 0, 0, 1, -1, 1, -1)
    val dy = arrayOf(0, 0, 1, -1, -1, -1, 1, 1)

    val (k, s, t) = readln().split(" ")
    val movingCount = t.toInt()

    var kingPoint = k.parsePoint()
    var stonePoint = s.parsePoint()
    val directions = Array(movingCount) { readln() }
    for (i in directions.indices) {
        val direction = directionMap[directions[i]]!!
        val kr = kingPoint.first + dy[direction]
        val kc = kingPoint.second + dx[direction]

        if (kr !in range || kc !in range) continue
        if (kr to kc == stonePoint) {
            // King이 움직일 곳에 Stone이 있는 경우
            val sr = stonePoint.first + dy[direction]
            val sc = stonePoint.second + dx[direction]

            if (sr !in range || sc !in range) continue
            stonePoint = sr to sc
        }
        kingPoint = kr to kc

    }

    print("${kingPoint.parsePoint()}\n${stonePoint.parsePoint()}")
}

private fun String.parsePoint(): Pair<Int, Int> {
    return (8 - this[1].digitToInt()) to (this[0].code - 65)
}

private fun Pair<Int, Int>.parsePoint(): String {
    return "${(65 + this.second).toChar()}${8 - this.first}"
}