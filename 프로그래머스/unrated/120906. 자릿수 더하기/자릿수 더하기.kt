class Solution {
    fun solution(n: Int): Int {
        var nn = n
        var result = 0
        
        while(nn > 0) {
            val remain = nn % 10
            result += remain    
            nn = nn / 10
        }
        return result
    }
}