fun main(){
    println(readln().split(" ").map(String::toInt).let { (a, b) -> a + b })
}