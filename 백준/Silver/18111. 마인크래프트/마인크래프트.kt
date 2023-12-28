import kotlin.math.absoluteValue

fun main() {
    val (n, m, b) = readln().split(" ").map(String::toInt)
    val map = Array(n) {
        readln().split(" ").map(String::toInt).toIntArray()
    }
    val allBlock = b + map.sumOf { it.sum() }
    val maxTargetHeight = allBlock / (n * m)
    var minSeconds = Int.MAX_VALUE
    var floor = 0

    val searchRange = 0 .. maxTargetHeight
    searchRange.forEach {
        var time = 0
        stop@ for (i in 0 until n) {
            for (j in 0 until m) {
                val gapBlock = it - map[i][j]
                if (gapBlock > 0) {
                    time += (gapBlock.absoluteValue)
                } else if (gapBlock < 0) {
                    time += (gapBlock.absoluteValue * 2)
                }
                if(time > minSeconds) break@stop  
            }
        }
        if(minSeconds >= time){
            minSeconds = time
            floor = it
        }
    }
    println("$minSeconds $floor")
}