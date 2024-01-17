fun main() {
    val comparator = Comparator<MutableMap.MutableEntry<Char, Int>> { o1, o2 ->
        when {
            o1.value < o2.value -> -1
            o1.value < o2.value -> 1
            o1.value == o2.value -> o2.key.compareTo(o1.key)
            else -> 0
        }
    }
    val (n, m) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().toCharArray() }
    val result = StringBuilder()

    repeat(m) { col ->
        val map = HashMap<Char, Int>()
        repeat(n) { row ->
            val char = board[row][col]
            map[char] = map.getOrDefault(char, 0) + 1
        }
        result.append(map.entries.sortedWith(comparator).last().key)
    }

    val find = result.toString().toCharArray()
    (0 until n)
        .fold(0) { acc, i ->
            acc + board[i].foldIndexed(0) { index, acc2, x -> if (x != find[index]) acc2 + 1 else acc2 }
        }
        .also { result.append("\n$it") }
    println(result.toString())
}