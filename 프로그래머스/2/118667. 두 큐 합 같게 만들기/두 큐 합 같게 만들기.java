import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        long q1Sum=0;
        long q2Sum=0;
        
        for(int i=0;i<queue1.length;i++){
            q1Sum += queue1[i];
            q2Sum += queue2[i];
            q1.add(queue1[i]); q2.add(queue2[i]);
        }
        
        // 원소들의 전체 합이 짝수가 아니라면 -1
        if((q1Sum+q2Sum)%2!=0) return -1; 
        
        while(q1Sum != q2Sum){
            if(answer>=(queue1.length)*3) return -1;
            else if(q1.isEmpty() || q2.isEmpty()) return -1;
            else if((q1Sum<q2Sum)){
                q1Sum += q2.peek();
                q2Sum -= q2.peek();
                q1.add(q2.poll());
            }
            else{
                q2Sum += q1.peek();
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            }
            answer++;
        }
        return answer;
    }
}