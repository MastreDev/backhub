fun main() {
    val n = readln().toInt()
    val buildMap = LinkedHashMap<Build, Int>().apply {
        repeat(n) {
            readln()
                .split(' ')
                .map(String::toInt)
                .also { (a, b) -> this[Build(it, a, b)] = 1 }
        }
    }
    buildMap.keys.forEach { a ->
        buildMap.keys.forEach { b ->
            if (a < b) buildMap[a] = buildMap[a]?.plus(1) ?: 1
        }
    }
    println(buildMap.values.joinToString(" "))
}

data class Build(
    val index: Int,
    val weight: Int,
    val height: Int,
) : Comparable<Build> {

    override fun compareTo(other: Build): Int {
        return when {
            weight > other.weight && height > other.height -> 1
            weight < other.weight && height < other.height -> -1
            else -> 0
        }
    }
}