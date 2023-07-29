// 채팅방에서 닉네임을 변경하면 기존 메시지의 닉네임도 변경
// 중복 닉네임이 있기때문에, 사용자 구별 unique가 있어야함.
// [uid.. // name]
class Solution {
    val commands = arrayOf("Enter","Leave","Change")
    val commandsMessages = arrayOf("%s님이 들어왔습니다.", "%s님이 나갔습니다.")
    val userMap = HashMap<String, String>()
    
    fun solution(record: Array<String>): Array<String> {
        val records : List<Record> = record.map {
            val split = it.split(" ")
            val command = split[0]
            val uid = split[1]
            val nickname = if(split.size ==3) split[2] else ""
            Record(command, uid, nickname)
        }
        
        records.filter{it.command == "Enter" || it.command == "Change"}
            .forEach { userMap[it.uid] = it.nickname }
        
        return records
            .filter{it.command == "Enter" || it.command == "Leave"}
            .map {
                val commandIndex = commands.indexOf(it.command)
                val message = commandsMessages[commandIndex]
                String.format(message, userMap[it.uid])
            }
            .toTypedArray()
    }
    
    data class Record(
        val command : String, val uid: String, val nickname:String)
}