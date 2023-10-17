class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        return str_list.filterNot{ it.contains(ex) }.joinToString("")
    }
}