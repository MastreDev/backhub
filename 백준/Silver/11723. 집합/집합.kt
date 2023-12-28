fun main() {
    val n = readln().toInt()
    val set = HashSet<Int>()
    val result = StringBuilder()

    repeat(n) {
        val split = readln().split(" ")

        when (split[0]) {
            "add" -> {
                split[1].toInt().also { set.add(it) }
            }

            "remove" -> {
                split[1].toInt().also { set.remove(it) }
            }

            "check" -> {
                split[1].toInt().also { param -> result.appendLine(1.takeIf { set.contains(param) } ?: 0) }
            }

            "toggle" -> {
                split[1].toInt().also { if (!set.remove(it)) set.add(it) }
            }

            "all" -> {
                set.clear()
                (1..20).forEach { set.add(it) }
            }

            "empty" -> {
                set.clear()
            }
        }

    }
    print(result)
}