class Solution {
    
    fun solution(a: Int, b: Int): Int {
        return when {
            a.isOdd() && b.isOdd() -> a* a + b* b
            a.isOdd() || b.isOdd() -> 2 * (a+b)
            a.isEven() && b.isEven() -> Math.abs(a - b)
            else -> 0
        }    
    }
    
    private fun Int.isEven() : Boolean = this % 2 == 0
    private fun Int.isOdd() : Boolean = !this.isEven()
}