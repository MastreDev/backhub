import java.util.LinkedList
import java.util.Stack

fun main() {

    // AAAA, BB
    val board = readln().toCharArray()
    // can not cover .
    // if not, println -1

    val sections = mutableListOf<List<Int>>()
    val temp = Stack<Int>()

    for (i in board.indices) {
        val current = board[i]
        if (current == 'X') {
            temp.add(i)
            continue
        }

        if (current == '.' && temp.isNotEmpty()) {
            sections.add(temp.toList())
            temp.clear()
        }

    }

    if (temp.isNotEmpty()) sections.add(temp.toList())

    outer@ for (i in sections.indices) {
        val section = sections[i].toCollection(LinkedList())

        while (section.isNotEmpty()) {
            val length = section.size
            when {
                length > 3 -> {
                    repeat(4) {
                        val slot = section.poll()!!
                        board[slot] = 'A'
                    }
                    continue
                }

                length == 2 -> {
                    repeat(2) {
                        val slot = section.poll()!!
                        board[slot] = 'B'
                    }
                }

                else -> break@outer
            }
        }
    }

    val permitChars = setOf('A', 'B', '.')
    val result = StringBuilder()
    for (i in board.indices) {
        if (board[i] !in permitChars) {
            result.clear().append("-1")
            break
        }
        result.append(board[i])

    }
    println(result.toString())
}