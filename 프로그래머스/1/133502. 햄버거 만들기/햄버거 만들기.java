import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        // stack의 경우는 get을 이용해 특정 index에 접근이 가능함
        int answer =0;
        Stack<Integer> stack = new Stack<>();
        
        for(int food : ingredient){
            stack.push(food);
            if(stack.size() >= 4){
                if(stack.get(stack.size()-1) ==1 &&
                stack.get(stack.size()-2) ==3 &&
                stack.get(stack.size()-3) ==2 &&
                stack.get(stack.size()-4) ==1){
                    answer ++;
                    for(int i=0;i<4;i++) stack.pop();
                }
            }
        }
        return answer;
    }
}