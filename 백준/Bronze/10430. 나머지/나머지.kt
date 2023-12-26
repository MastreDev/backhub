fun main(){
    //(A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C
    val (a, b, c) = readln().split(" ").map(String::toInt)
    println("${(a + b) % c}")
    println("${((a % c) + (b % c)) % c}")
    println("${(a * b) % c}")
    println("${((a % c) * (b % c)) % c}")
}