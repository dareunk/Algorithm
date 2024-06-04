import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 문제를 읽자마자 stack써야한다는 생각이 듦
        // 같은 인형이 연속해서 바구니에 존재하면 그 인형들은 사라짐
        
        // but 각 칸의 stack을 구성하는 것보다는 현재의 move를 저장하는 것이 더 효율적 -> 배열 5개보다는 1개가 더 효율적이니까
        int[] currentMoves = new int[board.length];
        for(int i=0;i<currentMoves.length;i++) currentMoves[i] = 0;
        Stack<Integer> basket = new Stack<>();
        
        int index=0;
        for(int move : moves){
            index = currentMoves[move-1];
            
            while(index<board.length){
                if(board[index][move-1] == 0) index++;
                else break;
            }
            if(index > board.length-1) continue;  
            if((!basket.isEmpty()) && basket.peek() == board[index][move-1]){
                basket.pop(); answer+=2;
            }
            else basket.push(board[index][move-1]); 
            currentMoves[move-1] = index+1;
        }
        
        return answer;
        
    }
}
 