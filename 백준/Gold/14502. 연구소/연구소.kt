fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val map = Array(n) { IntArray(m) }
    repeat(n) {
        map[it] = readln().split(' ').map(String::toInt).toIntArray()
    }
    val aWalls = map.flatMapIndexed { i: Int, ints: IntArray ->
        ints.withIndex().filter { it.value == 0 }.map { i to it.index }
    }

    val wallC = mutableListOf<List<Pair<Int, Int>>>()

    fun getWallCombinations(
        aWalls: List<Pair<Int, Int>>,
        selected: List<Pair<Int, Int>> = listOf(),
        index: Int = 0,
        r: Int = 3
    ) {
        if (selected.size == r) {
            wallC.add(selected)
            return
        }
        for (i in index until aWalls.size) {
            val newItem = aWalls[i]
            if (!selected.contains(newItem)) {
                getWallCombinations(aWalls, selected + newItem, i + 1, r)
            }
        }
    }
    getWallCombinations(aWalls)

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    fun transitionVirus(r: Int, c: Int, newMap: Array<IntArray>, visited : Array<BooleanArray>) {
        newMap[r][c] = 2
        visited[r][c] = true

        for (k in 0 until 4) {
            val rd = r + dx[k]
            val cd = c + dy[k]

            if (rd !in 0 until n || cd !in 0 until m) continue

            if (newMap[rd][cd] == 0 && !visited[rd][cd]) {
                transitionVirus(rd, cd, newMap, visited)
            }
        }
    }

    fun deepCopy(old: Array<IntArray>): Array<IntArray> {
        return Array(old.size) {
            old[it].copyOf()
        }
    }

    var answer = 0
    val visited = Array(n) { BooleanArray(m) }

    wallC.forEach { walls ->
        val newMap = deepCopy(map)
        walls.forEach {
            newMap[it.first][it.second] = 1
        }
        visited.forEach { it.fill(false) }

        for (i in newMap.indices) {
            for (j in newMap[i].indices) {
                if (newMap[i][j] == 2 && !visited[i][j]) {
                    transitionVirus(i, j, newMap, visited)
                }
            }
        }
        answer = maxOf(answer, newMap.flatMap { it.toList() }.filter { it == 0 }.size)

    }
    println(answer)
}