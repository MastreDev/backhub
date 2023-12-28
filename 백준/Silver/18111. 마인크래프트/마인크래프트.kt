import kotlin.math.absoluteValue

fun main() {
    val (n, m, b) = readln().split(" ").map(String::toInt)
    val map = Array(n) {
        readln().split(" ").map(String::toInt).toIntArray()
    }
    val allBlock = b + map.sumOf { it.sum() }
    val maxTargetHeight = allBlock / (n * m)
//    val results = mutableListOf<Pair<Int, Int>>()
    var minSeconds = Int.MAX_VALUE
    var floor = 0

    val searchRange = maxTargetHeight downTo 0
    searchRange.forEach {
        var time = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                val gapBlock = it - map[i][j]
                if (gapBlock > 0) {
                    time += (gapBlock.absoluteValue)
                } else if (gapBlock < 0) {
                    time += (gapBlock.absoluteValue * 2)
                }
            }
        }
        if(minSeconds == time){
            floor = maxOf(it, floor)
        }

        if(minSeconds > time){
            minSeconds = time
            floor = it
        }

//        results.add(time to it)
    }
    println("$minSeconds $floor")
//    val minTime = results.minOf { it.first }
//    results.filter { it.first == minTime }
//        .maxByOrNull { it.second }
//        ?.also { println("${it.first} ${it.second}") }
}