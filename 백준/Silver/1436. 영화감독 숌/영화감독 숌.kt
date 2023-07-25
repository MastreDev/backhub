fun main() {
    val n = readln().toInt()
    var searchCount = 0
    var currentNumber = 665

    while (searchCount < n) {
        currentNumber++
        var temp = currentNumber
        
        while(temp > 665){
            if(temp % 1000 == 666) {
                searchCount++
                break
            } else {
                temp /= 10
            }
        }
    }
    println(currentNumber)
}