fun main() {
    val n = readln().toInt()
    val result = 1.takeIf { (n % 4 == 0 && n % 100 != 0) || n % 400 == 0 } ?: 0
    println(result)
}