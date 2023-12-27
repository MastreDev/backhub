import java.util.LinkedList

fun main() {
    val testCount = readln().toInt()
    val works = LinkedList<DocWork>()
    repeat(testCount) {
        val (docCount, index) = readln().split(" ").map(String::toInt)
        val dequeue = readln().split(" ").map(String::toInt).withIndex().toCollection(ArrayDeque())
        works.add(DocWork(docCount, index, dequeue))
    }

    fun doPrint(work: DocWork) {
        var workIndex = 0
        val seq = work.seq

        myPrint@ while (true) {
            val first = seq.first()
            for (i in 1 until seq.size) {
                if (first.value < seq[i].value) {
                    seq.removeFirst().also { seq.addLast(it) }
                    continue@myPrint
                }
            }
            
            val doElement = seq.removeFirst()
            workIndex++
            if (doElement.index == work.targetIndex) {
                println(workIndex)
                break
            }
        }
    }

    while (works.isNotEmpty()) {
        doPrint(works.poll()!!)
    }
}

data class DocWork(
    val count: Int,
    val targetIndex: Int,
    val seq: ArrayDeque<IndexedValue<Int>>
)