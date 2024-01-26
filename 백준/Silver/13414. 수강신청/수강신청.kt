fun main() {
    val (k, l) = readln().split(" ").map(String::toInt)
    val set = linkedSetOf<String>()
    repeat(l) {
        val number = readln()
        if (!set.add(number)) {
            set.remove(number)
            set.add(number)
        }
    }
    println(set.take(k).joinToString("\n"))
}