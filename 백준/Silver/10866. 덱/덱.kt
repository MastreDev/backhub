fun main() {
    val n = readln().toInt()
    val commands = List(n) { readln() }

    val myDeque = ArrayDeque<Int>()
    val output = StringBuilder()

    for (raw in commands) {
        when {
            raw.startsWith("push_front") -> {
                val params = raw.split(" ")[1].toInt()
                myDeque.addFirst(params)
            }

            raw.startsWith("push_back") -> {
                val params = raw.split(" ")[1].toInt()
                myDeque.addLast(params)
            }

            raw == "pop_front" -> output.appendLine(myDeque.removeFirstOrNull() ?: -1)
            raw == "pop_back" -> output.appendLine(myDeque.removeLastOrNull() ?: -1)
            raw == "size" -> output.appendLine(myDeque.size)
            raw == "empty" -> output.appendLine(if (myDeque.isEmpty()) 1 else 0)
            raw == "front" -> output.appendLine(myDeque.firstOrNull() ?: -1)
            raw == "back" -> output.appendLine(myDeque.lastOrNull() ?: -1)
        }
    }

    print(output)
}