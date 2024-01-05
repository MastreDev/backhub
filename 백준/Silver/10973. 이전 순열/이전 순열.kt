fun main() {

    fun ArrayDeque<Int>.swap(from: Int, to: Int) {
        this[from].also {
            this[from] = this[to]
            this[to] = it
        }
    }

    val n = readln().toInt()
    val target = readln().split(" ").map(String::toInt).toCollection(ArrayDeque())

    if (target.sorted().joinToString() == target.joinToString()) {
        println(-1)
        return
    }

    var index = target.lastIndex
    while (index > 0) {
        val before = target[index - 1]
        if (before > target[index]) {
            val remains = target.subList(index, n).toMutableList()
            val switch = remains.filter { it < before }.max()
            repeat(remains.size + 1) { target.removeLast() }
            remains.remove(switch)
            remains.add(before)
            target.addLast(switch)
            target.addAll(remains.sortedDescending().toList())
            break
        }
        index--
    }

    println(target.joinToString(" "))

}