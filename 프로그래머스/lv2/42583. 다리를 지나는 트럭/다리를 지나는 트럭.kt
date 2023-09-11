import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val truckQueue : Queue<Int> = truck_weights.toCollection(LinkedList())
        val onBridge : Queue<Int> = LinkedList()
        var time = 0
        
        while(truckQueue.isNotEmpty()) {
            val current = truckQueue.peek()!!
            if(onBridge.sum() + current <= weight) {
                onBridge.offer(truckQueue.poll()!!)
                time++
            } else if(onBridge.size > bridge_length) {
                onBridge.remove()
                
            } else if (onBridge.size == bridge_length && onBridge.peek() > 0) {
                onBridge.remove()
                
            } else {
                onBridge.offer(0)
                time++
            }
        }
        
        return time + bridge_length
    }
}