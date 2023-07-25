fun main() {
    val rc = readln().toInt()
    val cols = IntArray(rc) { -1 }
    var answer = 0

    fun isPromising(r: Int, c: Int): Boolean {
        for (i in 0 until r) {
            if (cols[i] == c) return false
            if (Math.abs(i - r) == Math.abs(cols[i] - c)) return false
        }
        return true
    }

    fun backtracking(row: Int) {
        if (row == rc) {
            answer++
            return
        }

        for (col in 0 until rc) {
            if (isPromising(row, col)) {
                cols[row] = col
                backtracking(row + 1)
                cols[row] = -1
            }
        }
    }

    backtracking(0)
    println(answer)
}