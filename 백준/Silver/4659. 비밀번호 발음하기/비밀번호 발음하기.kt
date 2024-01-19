import java.util.Stack

fun main() {
    // a, e, i , o, u must contain at least 1
    // 모음 3개 or 자음 3개 연속 불가
    // 같은 글자 연속 두번 안되지만 ee, oo 허용
    val stack = Stack<Char>()
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun Char.isVowel() = this in vowels
    fun Char.isConsonant() = !this.isVowel()

    val sentences = mutableListOf<String>()
    while (true) {
        val sentence = readln()
        if (sentence == "end") break
        sentences.add(sentence)
    }

    for(i in sentences.indices) {
        val sentence = sentences[i]
        stack.clear()
        var vowelCount = 0
        var tripleVowel = false
        var tripleConsonant = false
        var doubleSameChar = false

        sentence.forEach {
            if (it in vowels) vowelCount++
            if (stack.isEmpty()) {
                stack.push(it)
                return@forEach
            }

            val before = stack.pop()
            if (before == null) {
                stack.push(it)
                return@forEach
            }

            if (before == it && (it != 'e' && it != 'o')) {
                doubleSameChar = true
                stack.push(before)
                stack.push(it)
                return@forEach
            }
            if (stack.isEmpty()) {
                stack.push(before)
                stack.push(it)
                return@forEach
            }

            val beforeBefore = stack.peek()
            if (beforeBefore == null) {
                stack.push(before)
                stack.push(it)
                return@forEach
            }

            //세 글자인 경우 ->
            if (beforeBefore.isVowel() && before.isVowel() && it.isVowel()) {
                tripleVowel = true
            }
            if (beforeBefore.isConsonant() && before.isConsonant() && it.isConsonant()) {
                tripleConsonant = true
            }
            stack.push(before)
            stack.push(it)
        }

        val validTest = "is acceptable.".takeIf { vowelCount > 0 && !tripleVowel && !tripleConsonant && !doubleSameChar } ?: "is not acceptable."
        println("<$sentence> $validTest")
    }

}