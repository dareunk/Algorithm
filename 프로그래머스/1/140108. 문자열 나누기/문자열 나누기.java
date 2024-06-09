class Solution {
    public int solution(String s) {
        int answer = 0;
        int firstNumber =0; int otherNumber =0;
        char first = s.charAt(0);
        for(char c : s.toCharArray()){
            if(firstNumber ==0 && otherNumber ==0) first = c;
            
            if(c == first) firstNumber++;
            else if(c!=first) otherNumber++;
            
            if(firstNumber == otherNumber){
                firstNumber =0;
                otherNumber =0;
                answer++;
            }
        }
        if(firstNumber != 0 || otherNumber != 0) answer++;
        return answer;
    }
}