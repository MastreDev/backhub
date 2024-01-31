import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))

private val dx = arrayOf(1, 1, 0)
private val dy = arrayOf(0, 1, 1)

fun main() {
    // 8x8 -> 4x4 -> 2x2 -> 1x1
    // 2x2 행렬로 나눈다.
    // 각 사각형에서 두번째로 큰 수만 남긴다
    val n = br.readLine().toInt()
    val array = Array(n) { br.readLine().split(" ").map(String::toInt).toIntArray() }

    val result = compress(array)
    bw.write(result[0][0].toString())
    bw.close()
    br.close()
}

private fun compress(origin: Array<IntArray>): Array<IntArray> {
    val n = origin.size
    if (n == 1) return origin
    val linear = LinkedList<Int>()
    for (i in 0 until n step 2) {
        for (j in 0 until n step 2) {
            val temp = mutableListOf(origin[i][j])
            for (d in 0 until 3) {
                val ni = i + dy[d]
                val nj = j + dx[d]
                temp.add(origin[ni][nj])
            }
            temp.sort()
            linear.add(temp[2])
        }
    }
    val next = Array(n / 2) { IntArray(n / 2) { linear.poll()!! } }
    return compress(next)
}