import kotlin.math.*
import java.util.*

class Solution {
    
    lateinit var nums : IntArray
    lateinit var visited : BooleanArray
    val results = mutableListOf<Int>()
    var answer = 0
    
    fun solution(numbers: String): Int {
        nums = numbers.toCharArray().map(Char::digitToInt).toIntArray()
        visited = BooleanArray(numbers.length)
        
        repeat(numbers.length) {
            permutation(it + 1, 0, mutableListOf<Int>())    
        }
        
        return results.distinct().count{it.isPrime()}
    }
    
    fun permutation(n : Int, depth : Int, container : MutableList<Int>) {
        if(n == depth) {
            // if(container.joinToString("").toInt().isPrime()) answer++
            results.add(container.joinToString("").toInt())
            return
        }
        for(i in nums.indices) {
            if(visited[i] == true) continue
            
            visited[i] = true
            container.add(nums[i])
            permutation(n, depth + 1, container)
            container.removeLast()
            visited[i] = false
        }
    }
    
    fun Int.isPrime() : Boolean {
        if(this < 2) return false
        val half = sqrt(this.toDouble()).toInt()
        for(i in half downTo 2) {
            if(this % i == 0) return false
        }
        return true
    }
}