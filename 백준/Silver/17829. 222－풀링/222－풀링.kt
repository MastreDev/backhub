import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

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

    fun divide(i: Int, j: Int, size: Int): Int {
        val arr = IntArray(4)
        if (size == 2) {
            arr[0] = array[i][j]
            for (d in 0 until 3) {
                val ni = i + dy[d]
                val nj = j + dx[d]
                arr[d + 1] = array[ni][nj]
            }
        } else {
            val half = size / 2
            arr[0] = divide(i, j, half)
            arr[1] = divide(i, j + half, half)
            arr[2] = divide(i + half, j + half, half)
            arr[3] = divide(i + half, j, half)
        }
        arr.sort()
        return arr[2]
    }

    val result = divide(0, 0, n)
    bw.write(result.toString())
    bw.close()
    br.close()
}