fun main(){
    val (a, b) = readln().split(" ").map(String::toInt)
    println(a.plus(b))
    println(a.minus(b))
    println(a.times(b))
    println(a.div(b))
    println(a % b)
}