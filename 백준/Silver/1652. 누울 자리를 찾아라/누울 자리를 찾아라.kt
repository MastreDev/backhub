fun main() {
    val n = readln().toInt()
    val room = Array(n) { readln().toCharArray() }

    var rowCount = 0
    var colCount = 0

    for (i in 0 until n) {
        val rowBuffer = mutableListOf<Char>()
        for (j in 0 until n) {
            val cell = room[i][j]
            if (cell == '.') {
                rowBuffer.add('.')
                continue
            }
            if (rowBuffer.size > 1) rowCount++
            rowBuffer.clear()
        }
        if (rowBuffer.size > 1) rowCount++

        val colBuffer = mutableListOf<Char>()
        for (j in 0 until n) {
            val cell = room[j][i]
            if (cell == '.') {
                colBuffer.add('.')
                continue
            }
            if (colBuffer.size > 1) colCount++
            colBuffer.clear()
        }
        if (colBuffer.size > 1) colCount++
    }

    println("$rowCount $colCount")
}