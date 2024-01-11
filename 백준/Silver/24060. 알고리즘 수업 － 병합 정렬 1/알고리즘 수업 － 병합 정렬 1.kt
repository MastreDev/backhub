fun main() {

    val (n, k) = readln().split(" ").map(String::toInt)
    val array = readln().split(" ").map(String::toInt).toIntArray()
    val temp = IntArray(array.size)

    var saveCount = 0
    val history = hashMapOf<Int, Int>()

    fun Int.record(): Int {
        history[++saveCount] = this
        return this
    }

    fun merge(array: IntArray, p: Int, q: Int, r: Int) {
        var i = p
        var j = q + 1
        var t = -1

        while (i <= q && j <= r) {
            temp[++t] = array[if (array[i] > array[j]) j++ else i++].record()
        }
        while (i <= q) {
            temp[++t] = array[i++].record()
        }
        while (j <= r) {
            temp[++t] = array[j++].record()
        }
        i = p
        t = -1
        while (i <= r) {
            array[i++] = temp[++t]
        }
    }

    fun mergeSort(array: IntArray, p: Int = 0, r: Int = array.lastIndex) {
        if (p >= r) return
        val q = (p + r) / 2
        mergeSort(array, p, q)
        mergeSort(array, q + 1, r)
        merge(array, p, q, r)
    }

    mergeSort(array)
    println(history.getOrDefault(k, -1))

}