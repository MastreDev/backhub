import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val truckQueue : Queue<Int> = truck_weights.toCollection(LinkedList())
        val onBridge : Queue<Int> = IntArray(bridge_length).toCollection(LinkedList())
        var time = 0
        
        while(truckQueue.isNotEmpty()) {
            time++
            onBridge.remove()
            val current = truckQueue.peek()!!
            if(onBridge.sum() + current <= weight) {
                onBridge.offer(truckQueue.poll()!!)
            } else {
                onBridge.offer(0)
            }
        }
        
        return time + bridge_length
    }
}