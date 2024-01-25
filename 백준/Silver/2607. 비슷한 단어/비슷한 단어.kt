fun main() {
    // 하나의 문자를 더하거나, 빼거나, 바꾼다
    val n = readln().toInt()
    val words = Array(n) { readln().toList() }
    // 하나의 아무 문자를 더해서 구성이 같아지거나
    // 하나의 아무 문자를 빼서 구성이 같아지거나
    // 하나의 아무 문자를 바꿔서 구성이 같아져야 한다

    val word = words[0].toList()
    var similarCount = 0

    words.drop(1).forEach { other ->
        val tempWord = word.toMutableList().also { it.sort() }
        val tempOther = other.toMutableList().also { it.sort() }
        if (tempWord.size <= tempOther.size) {
            if (tempWord.isSimilar(tempOther)) similarCount++
        } else {
            if (tempOther.isSimilar(tempWord)) similarCount++
        }
    }
    println(similarCount)
}

private fun MutableList<Char>.isSimilar(other: MutableList<Char>): Boolean {
    while (this.isNotEmpty()) {
        other.remove(this.removeFirst())
    }
    return other.isEmpty() || other.size == 1
}