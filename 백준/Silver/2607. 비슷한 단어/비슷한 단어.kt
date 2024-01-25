fun main() {
    val n = readln().toInt()
    val words = Array(n) { readln() }
    val word = words[0]
    var similarCount = 0

    words.drop(1).forEach { other ->
        val tempWord = word.toMutableList().also { it.sort() }
        val tempOther = other.toMutableList().also { it.sort() }

        val (short, long) = if (tempWord.size <= tempOther.size) tempWord to tempOther else tempOther to tempWord
        if (short.isSimilar(long)) similarCount++
    }
    println(similarCount)
}

private fun MutableList<Char>.isSimilar(bigger: MutableList<Char>): Boolean {
    while (this.isNotEmpty()) {
        bigger.remove(this.removeFirst())
    }
    return bigger.size < 2
}