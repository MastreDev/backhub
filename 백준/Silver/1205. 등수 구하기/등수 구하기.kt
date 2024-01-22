fun main() {
    val (n, newScore, p) = readln().split(" ").map(String::toInt)
    if (n <= 0) {
        println(1)
        return
    }
    val scoreBoard = readln().split(" ").map(String::toInt).toMutableList()
    if (scoreBoard.size == p && scoreBoard.last() >= newScore) {
        println(-1)
        return
    }
    scoreBoard.apply {
        this.add(newScore)
        this.sortDescending()
    }
    val rankEntries = scoreBoard.take(p).groupingBy { it }.eachCount().entries.sortedByDescending { it.key }
    var acc = 0
    for (i in rankEntries.indices) {
        if (rankEntries[i].key == newScore) {
            println(acc + 1)
            return
        }
        acc += rankEntries[i].value
    }
    println(-1)
}