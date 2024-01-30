import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    // 키 순서 1번 부터 시작. 항상 20명 같은 키 없음
    repeat(readln().toInt()) {
        val students = br.readLine().split(" ").map(String::toInt)
        val testNumber = students.first()
        val queue = LinkedList<Int>()
        val temp = LinkedList<Int>()
        var walkCount = 0

        for (i in 1 until students.size) {
            val student = students[i]

            while (queue.isNotEmpty()) {
                val last = queue.peek()!!
                if (last > student) break
                temp.offer(queue.poll()!!)
            }

            walkCount += queue.size
            temp.offer(student)
            while (queue.isNotEmpty()) {
                temp.offer(queue.poll()!!)
            }
            while (temp.isNotEmpty()) {
                queue.offer(temp.poll()!!)
            }
        }
        bw.write("$testNumber $walkCount")
        bw.newLine()
    }
    bw.close()
    br.close()
}