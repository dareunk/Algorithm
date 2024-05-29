import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int number : numbers){
            list.add(number);
        }
        for(int i=0;i<10;i++){
            if(!list.contains(i)) answer += i;
        }
        return answer;
    }
}