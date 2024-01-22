fun main() {
    val ori = readln()
    val results = mutableListOf<String>()

    fun String.eachReverse(s: Int, e: Int) {
        val builder = StringBuilder()
        this.substring(0 until s).reversed().also { builder.append(it) }
        this.substring(s until e).reversed().also { builder.append(it) }
        this.substring(e until ori.length).reversed().also { builder.append(it) }
        results.add(builder.toString())
    }

    for (i in 1 until ori.lastIndex) {
        for (j in i + 1 until ori.length) {
            ori.eachReverse(i, j)
        }
    }

    results.apply { this.sort() }.first().also { println(it) }
}