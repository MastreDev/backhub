fun main() {
    val (r, c, n) = readln().split(" ").map(String::toInt)
    val init = Array(r) { readln().toCharArray() }
    val initialBombs = mutableListOf<Pair<Int, Int>>()
    val afterBombs = mutableListOf<Pair<Int, Int>>()
    repeat(r) { i ->
        repeat(c) { j ->
            if (init[i][j] == 'O') initialBombs.add(i to j)
        }
    }
    val fullInstallBombs = Array(r) { CharArray(c) { 'O' } }
    val explodeInitialBombs = Array(r) { CharArray(c) { 'O' } }
    val explodeAfterBombs = Array(r) { CharArray(c) { 'O' } }

    fun explode() {
        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, -1, 0, 1)
        initialBombs.forEach {
            val (row, col) = it
            explodeInitialBombs[row][col] = '.'
            for (i in 0 until 4) {
                val dr = row + dy[i]
                val dc = col + dx[i]
                if (dr !in 0 until r || dc !in 0 until c) continue
                explodeInitialBombs[dr][dc] = '.'
            }
        }
    }

    fun explodeAfterBombs() {
        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, -1, 0, 1)
        afterBombs.forEach {
            val (row, col) = it
            explodeAfterBombs[row][col] = '.'
            for (i in 0 until 4) {
                val dr = row + dy[i]
                val dc = col + dx[i]
                if (dr !in 0 until r || dc !in 0 until c) continue
                explodeAfterBombs[dr][dc] = '.'
            }
        }
    }

    explode()
    repeat(r) { i ->
        repeat(c) { j ->
            if (explodeInitialBombs[i][j] == 'O') afterBombs.add(i to j)
        }
    }
    explodeAfterBombs()

    val scene = n % 4
    when {
        n == 1 -> init
        scene == 0 || scene == 2 -> fullInstallBombs
        scene == 3 -> explodeInitialBombs
        scene == 1 -> explodeAfterBombs
        else -> emptyArray()
    }.also {
        StringBuilder().apply {
            it.forEach { r -> this.appendLine(r.joinToString("")) }
            println(this.toString())
        }
    }
}