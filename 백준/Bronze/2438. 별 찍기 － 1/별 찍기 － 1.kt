fun main() {
    val n = readln().toInt()
    repeat(n) {
        val builder = StringBuilder()
        (0..it).fold(builder) { acc, _ ->
            acc.append("*")
        }
        println(builder.toString())
    }
}