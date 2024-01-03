fun main() {
    class Result(
        val countryCode: Int,
        val gold: Int,
        val silver: Int,
        val bronze: Int
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
            var result = gold
            result = 31 * result + silver
            result = 31 * result + bronze
            return result
        }
    }

    val (n, k) = readln().split(" ").map(String::toInt)
    val board = Array(n) { readln().split(" ").map(String::toInt).let { Result(it[0], it[1], it[2], it[3]) } }
    val rank = board.groupBy { it }
    val target = board.first { it.countryCode == k }

    rank.keys.sortedDescending().indexOf(target).also { println(it + 1) }
}