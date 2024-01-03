fun main() {
    class Result(
        val countryCode: Int,
        val gold: Long,
        val silver: Long,
        val bronze: Long
    ) : Comparable<Result> {

        override fun compareTo(other: Result): Int {
            if (other.gold > gold) return -1
            if (other.gold < gold) return 1
            if (other.silver > silver) return -1
            if (other.silver < silver) return 1
            if (other.bronze > bronze) return -1
            if (other.bronze < bronze) return 1

            return 0
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Result

            if (gold != other.gold) return false
            if (silver != other.silver) return false
            return bronze == other.bronze
        }

        override fun hashCode(): Int {
            var result = gold.hashCode()
            result = 31 * result + silver.hashCode()
            result = 31 * result + bronze.hashCode()
            return result
        }

    }

    val (n, k) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().split(" ").map(String::toLong).let { Result(it[0].toInt(), it[1], it[2], it[3]) } }
    val rank = board.groupingBy { it }.eachCount()
    val target = board.first { it.countryCode == k }

    val ranking = rank.keys.sortedDescending()
    var result = 1
    for (i in ranking.indices) {
        if (ranking[i] == target) break
        result += rank[ranking[i]]!!
    }
    println(result)
}