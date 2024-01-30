import java.text.DecimalFormat

fun main() {
    val n = readln().toInt()
    val record = Array(n) {
        val (team, rTime) = readln().split(" ")
        val (rHour, rMin) = rTime.split(":")
        val time = rHour.toInt() * 60 + rMin.toInt()
        arrayOf(team.toInt(), time)
    }
    val duration = 48 * 60
    var aTeamWinDuration = 0
    var bTeamWinDuration = 0
    val score = arrayOf(0, 0)
    var lastGoalTime = 0

    record.forEach {
        val team = it[0]
        val time = it[1]

        when {
            score[0] < score[1] -> {
                score[team - 1]++ // 득점 기록
                bTeamWinDuration += time - lastGoalTime
                lastGoalTime = time
            }

            score[0] > score[1] -> {
                score[team - 1]++ // 득점 기록
                aTeamWinDuration += time - lastGoalTime
                lastGoalTime = time
            }

            else -> {
                score[team - 1]++ // 득점 기록
                lastGoalTime = time
            }
        }
    }

    if (score[0] > score[1]) {
        aTeamWinDuration += duration - lastGoalTime

    } else if (score[0] < score[1]) {
        bTeamWinDuration += duration - lastGoalTime
    }

    println("${aTeamWinDuration.toResult()}\n${bTeamWinDuration.toResult()}")
}

private val format = DecimalFormat("00")
private fun Int.toResult(): String {
    return "${format.format(this / 60)}:${format.format(this % 60)}"
}