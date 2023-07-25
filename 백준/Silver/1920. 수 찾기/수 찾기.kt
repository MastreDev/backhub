fun main() {
    readln().toInt()
    val nNumbers = readln().split(' ').map(String::toInt).sorted()
    readln().toInt()
    val mNumbers = readln().split(' ').map(String::toInt)

    mNumbers
        .map { nNumbers.binarySearch(it) }
        .map { if (it < 0) 0 else 1 }
        .forEach { println(it) }
}