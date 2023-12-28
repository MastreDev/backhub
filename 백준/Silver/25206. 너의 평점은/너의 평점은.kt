fun main() {
    val grades = hashMapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0.0,
    )

    data class MyScore(
        val name: String,
        val point: Double,
        val grade: String,
    ) {
        val isPass get() = grade == "P"
        val pointMultiGrade get() = point * grades[grade]!!
    }

    var pointMultiGrades = 0.0
    var sumPoints = 0.0

    repeat(20) {
        val score = readln().split(" ").let { MyScore(it[0], it[1].toDouble(), it[2]) }
        if (!score.isPass) {
            sumPoints += score.point
            pointMultiGrades += score.pointMultiGrade
        }
    }
    println(pointMultiGrades / sumPoints)
}