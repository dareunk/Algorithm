class Solution {
    public int solution(String s) {
        int answer = 0;
        int firstNumber = 0;
        int otherNumber = 0;

        int i=0;
        while(s.length()>0 && i < s.length()){
    
            char first = s.charAt(0);
            if(first == s.charAt(i)) firstNumber++;
            if(s.length() == 1) { break;}
            else if(first != s.charAt(i)) otherNumber++;
            i++;
            
            if(firstNumber == otherNumber) {
                s = s.substring(i,s.length()); 
                answer++;
                firstNumber =0; otherNumber=0;
                i=0;
            }
        }
        if(otherNumber ==0 && firstNumber >0) answer ++;
        if(otherNumber != 0) answer++;
     
  
        return answer;
    }
}