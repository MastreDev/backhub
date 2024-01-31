import java.util.LinkedList
import java.util.Stack

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val n = br.readLine().toInt()
    val works = Array(n) {
        br.readLine().split(" ").map(String::toInt).toIntArray()
    }.toCollection(LinkedList())
    val desk = Stack<IntArray>()

    var time = 0
    var score = 0

    while (works.isNotEmpty()) {
        val work = works.poll()!!
        if (work[0] == 1) {
            if (--work[2] == 0) {
                score += work[1]
            } else {
                desk.push(work)
            }

        } else {
            if (desk.isNotEmpty()) {
                val task = desk.pop()!!
                if (--task[2] == 0) {
                    score += task[1]
                } else {
                    desk.push(task)
                }
            }
        }
        time++
    }

    bw.write(score.toString())
    bw.close()
    br.close()
}