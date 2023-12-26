fun main(){
    
    var n = readln().toInt()
    var diagonal = 1

    while (n > diagonal) {
        n -= diagonal
        diagonal++
    }

    if (diagonal % 2 == 0) {
        println("$n/${diagonal - n + 1}")
    } else {
        println("${diagonal - n + 1}/$n")
    }
}