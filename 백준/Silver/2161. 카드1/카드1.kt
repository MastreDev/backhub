import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val deck = IntArray(n) { it + 1 }
    val cards = deck.toCollection(ArrayDeque())
    val trashCards: Queue<Int> = LinkedList()

    fun shuffle() {
        while (cards.size > 1) {
            cards.removeFirst().also { trashCards.add(it) }
            cards.removeFirst().also { cards.addLast(it) }
        }
    }
    shuffle()
    val result = StringBuilder()
    while (trashCards.isNotEmpty()) {
        result.append(trashCards.poll()!!).append(" ")
    }
    result.append(cards[0])
    println(result.toString())
}