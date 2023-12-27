fun main() {
    val count = readln().toInt()
    val map = Array(100) { IntArray(100) }

    repeat(count) {
        val (x, y) = readln().split(" ").map(String::toInt)
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                map[100 -j][i] = 1
            }
        }
    }
    println(map.flatMap { it.toList() }.count { it == 1 })
}