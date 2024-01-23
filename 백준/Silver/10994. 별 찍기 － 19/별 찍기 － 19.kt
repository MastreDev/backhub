fun main() {
    val n = readln().toInt()
    val side = 4 * n - 3
    var end = side - 1
    val sketchBook = CharArray(side) { '*' }
    val result = StringBuilder()

    repeat(side) { i ->
        if (end < i) {
            if (i % 2 == 0) {
                (end..i).forEach { sketchBook[it] = '*' }
            } else {
                (end..i).forEach { sketchBook[it] = ' ' }
            }
        } else {
            if (i % 2 == 0) {
                (i..end).forEach { sketchBook[it] = '*' }
            } else {
                (i..end).forEach { sketchBook[it] = ' ' }
            }
        }
        result.appendLine(sketchBook.joinToString(""))
        end--
    }
    print(result.toString())
}