import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val terms = br.readLine()
    //gap - 32
    // 소문자만 사용한다. 단어와 단어를 구분하기 위해서 밑줄('_')을 이용한다
    // 소문자 체크
    val isUseOnlyLowerCase = terms.replace("_", "").fold(true) { acc, c -> acc && c.code in 97..122 }
    // 연속으로 __ 나오는 걸 체크
    val isNotSeqUnderBar = terms.split("_").fold(true) { acc, s -> acc && s.isNotEmpty() }
    val isCpp = isUseOnlyLowerCase && isNotSeqUnderBar
    // 첫 단어는 소문자로 쓰고, 다음 단어부터는 첫 문자만 대문자로 쓴다. 또, 모든 단어는 붙여쓴다.
    val isStartLowerCase = terms.first().code in 97..122
    val isNotContainsUnderBars = terms.count { it == '_' } == 0
    val isJava = isStartLowerCase && isNotContainsUnderBars && terms.count { it.code in 65..90 } > 0

    val newTerms = mutableListOf<Char>()
    if (isCpp) {
        terms.split("_").map(String::toCharArray).forEachIndexed { index, array ->
            if (index == 0) {
                newTerms.addAll(array.toList())
            } else {
                array[0] = (array[0].code - 32).toChar()
                newTerms.addAll(array.toList())
            }
        }
    } else if (isJava) {
        terms.forEach { c ->
            if (c.code in 65..90) {
                newTerms.add('_')
                newTerms.add(c.code.plus(32).toChar())
            } else {
                newTerms.add(c)
            }
        }
    } else {
        newTerms.addAll("Error!".toList())
    }

    bw.write(newTerms.joinToString(""))

    bw.close()
    br.close()
}