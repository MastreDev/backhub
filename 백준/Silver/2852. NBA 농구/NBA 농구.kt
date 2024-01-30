import java.text.DecimalFormat

fun main() {
    val n = readln().toInt()
    val record = Array(n) { readln().split(" ") }
    val duration = "48:00"
    var aTeamWinDuration = "00:00"
    var bTeamWinDuration = "00:00"
    var score = arrayOf(0, 0)
    var lastGoalTime = "00:00"

    record.forEach {
        val team = it[0].toInt()
        val time = it[1]

        if (score[0] == score[1]) {
            // 이전까지 동점,
            score[team - 1]++ // 득점 기록
            lastGoalTime = time

        } else if (score[0] > score[1]) {
            // a팀이 이기고 있는 상황
            score[team - 1]++ // 득점 기록
            val gap = time.minusTime(lastGoalTime)
            aTeamWinDuration = aTeamWinDuration.plusTime(gap)
            lastGoalTime = time

        } else {
            // b팀이 이기고 있는 상황
            score[team - 1]++ // 득점 기록
            val gap = time.minusTime(lastGoalTime)
            bTeamWinDuration = bTeamWinDuration.plusTime(gap)
            lastGoalTime = time
        }
    }

    if (score[0] > score[1]) {
        val gap = duration.minusTime(lastGoalTime)
        aTeamWinDuration = aTeamWinDuration.plusTime(gap)

    } else if (score[0] < score[1]) {
        val gap = duration.minusTime(lastGoalTime)
        bTeamWinDuration = bTeamWinDuration.plusTime(gap)
    }

    println(aTeamWinDuration)
    println(bTeamWinDuration)

}

private fun String.minusTime(before: String): String {
    val thisHour = this.split(":")[0].toInt()
    val thisMin = this.split(":")[1].toInt()

    val otherHour = before.split(":")[0].toInt()
    val otherMin = before.split(":")[1].toInt()

    val gap = thisHour * 60 + thisMin - otherHour * 60 - otherMin
    val format = DecimalFormat("00")
    return "${format.format(gap / 60)}:${format.format(gap % 60)}"
}

private fun String.plusTime(before: String): String {
    val thisHour = this.split(":")[0].toInt()
    val thisMin = this.split(":")[1].toInt()

    val otherHour = before.split(":")[0].toInt()
    val otherMin = before.split(":")[1].toInt()

    val gap = thisHour * 60 + thisMin + otherHour * 60 + otherMin
    val format = DecimalFormat("00")
    return "${format.format(gap / 60)}:${format.format(gap % 60)}"
}