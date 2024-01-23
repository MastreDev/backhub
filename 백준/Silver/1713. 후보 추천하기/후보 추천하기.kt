fun main() {
    val containerCount = readln().toInt()
    readln().toInt()
    val voting = readln().split(" ").map(String::toInt)
    val candidates = LinkedHashMap<Int, Int>()
    val gallery = LinkedHashSet<Int>()

    voting.forEach { current ->
        gallery.add(current)
        if (gallery.size > containerCount) {
            val minVoteCount = candidates.minOfOrNull { it.value }
            val willRemoves = candidates.entries.filter { it.value == minVoteCount }.map { it.key }.toSet()
            val removeTarget = gallery.firstOrNull { it in willRemoves }
            gallery.remove(removeTarget)
            candidates.remove(removeTarget)
        }
        candidates[current] = candidates.getOrDefault(current, 0) + 1
    }
    println(gallery.sorted().joinToString(" "))
}