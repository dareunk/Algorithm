import java.util.*;
import java.util.stream.*;
class Solution {
    static int N;
    static int[][] Q;
    static int[] ANS;
    static int answer = 0;
    static List<Integer> list = new LinkedList<>();
    public int solution(int n, int[][] q, int[] ans) {
        N=n;
        Q=q;
        ANS=ans;
        comb(0,1);
        return answer;
    }
    public static void comb(int length, int start){
        if(length == 5){
            boolean isValidated = checkValidation();
            if(isValidated) answer++;
            return;
        }
        for(int i=start;i<=N;i++){
            list.add(i);
            comb(length+1,i+1);
            list.remove(list.size()-1);
        }
    }
    public static boolean checkValidation(){
        int count;
  
        for(int i=0;i<Q.length;i++){
         count =0;
        /*
            //실험 1. list의 retainAll 사용
         List<Integer> temp = Arrays.stream(Q[i]).boxed().collect(Collectors.toList());
         temp.retainAll(list);
         count = temp.size();
         if(count != ANS[i]) return false;
        
        }
        */
         //실험 2. 반복문 사용
        for(int j=0;j<5;j++){
            for(int num : list){
                if(num == Q[i][j]) count++;
            }
        }
        if(count != ANS[i]) return false; 
    }
    return true;
}
    
    
}