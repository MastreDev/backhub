import kotlin.math.roundToInt

fun main() {
    val n = readln().toInt()
    val numbers = List(n) { readln().toInt() }.sorted()

    val numberMap = numbers.groupingBy { it }.eachCount().entries.groupBy { it.value }.map { entry ->  entry.key to entry.value.map { it.key }.sorted() }.sortedByDescending { it.first }

    val result = StringBuilder().apply {
        this.appendLine(numbers.average().roundToInt())
        this.appendLine(numbers[n / 2])
        val maxBin = numberMap[0]
        if(maxBin.second.size > 1){
            this.appendLine(numberMap[0].second[1])
        } else {
            this.appendLine(numberMap[0].second[0])
        }
        this.appendLine(numbers.last() - numbers.first())
    }
    print(result)
}