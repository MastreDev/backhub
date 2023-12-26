fun main(){
    val (a, b) = readln().split(" ").map(String::toInt)
    when{
        a > b -> ">"
        a < b -> "<"
        else -> "=="
    }.let{ println(it) }
}