private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val homeScore = br.readLine().split(" ").map(String::toInt).toIntArray()
    val awayScore = br.readLine().split(" ").map(String::toInt).toIntArray()
    br.close()

    var home = 0
    var away = 0

    for (i in 0 until 9) {
        repeat(homeScore[i]) {
            home++
            if (home > away) {
                bw.write("Yes")
                bw.close()
                return
            }
        }
        away += awayScore[i]
    }
    bw.write("No")
    bw.close()
}