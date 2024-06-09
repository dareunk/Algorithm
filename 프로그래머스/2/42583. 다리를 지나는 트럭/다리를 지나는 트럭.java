import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int sumInQueue = 0;
        for(int truck : truck_weights){
            
            while(true){
                if(q.size() == bridge_length) {sumInQueue -= q.poll();} 
                if(sumInQueue + truck <= weight){
                    q.add(truck);
                    sumInQueue += truck;
                    answer++;
                    break;
                }else{
                    q.add(0);
                    answer++;
                }
            }
        }
        // 마지막 요소가 queue에서 빠져나오는 것 까지 고려해야하므로 bridge_length를 합산해줘야함 
        return answer + bridge_length;
    }
}