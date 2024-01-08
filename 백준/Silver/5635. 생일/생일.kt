fun main() {

    class Person(
        val name: String, val year: Int, val month: Int, val day: Int
    ) : Comparable<Person> {

        override fun compareTo(other: Person): Int {
            if (this.year < other.year) return 1
            if (this.year > other.year) return -1
            if (this.month < other.month) return 1
            if (this.month > other.month) return -1
            if (this.day < other.day) return 1
            if (this.day > other.day) return -1
            return 0
        }
    }

    val n = readln().toInt()
    val persons = List(n) {
        readln().split(" ").let { Person(it[0], it[3].toInt(), it[2].toInt(), it[1].toInt()) }
    }.sorted()

    println("${persons[0].name}\n${persons[n - 1].name}")

}