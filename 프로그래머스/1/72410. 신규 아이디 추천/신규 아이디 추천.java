class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        answer = new_id.toLowerCase();
        
        // 2단계
        
        String temp = new String();
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)>=97 && answer.charAt(i)<=122) temp += answer.charAt(i);
            else if(answer.charAt(i)=='_' || answer.charAt(i)=='-' || answer.charAt(i)=='.') temp += answer.charAt(i);
            else if(answer.charAt(i)>=48 && answer.charAt(i)<=57) temp += answer.charAt(i);
        }
        answer =temp;
        
        
        // 3단계
        
        temp="";
        int index;
        for(int i=0;i<answer.length();i++){
        temp += answer.charAt(i);
        if(answer.charAt(i) == '.'){
            int j=i+1;
            while(j<answer.length()){
                if(answer.charAt(j) == '.') {j++; i++;}
                else break;
            }
        }
        
        }
        answer = temp;
        
        
        // 4단계
        int length = answer.length();
       if(answer.charAt(0) == '.') answer = answer.substring(1,length);
       else if(answer.charAt(length-1) == '.') answer = answer.substring(0,length-1);
        
        // 5단계
        if(answer.isEmpty()) answer = "a";
        
        // 6단계
       if(answer.length()>=16) answer = answer.substring(0,15);
       if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0,answer.length()-1);
        
        // 7단계
        
        if(answer.length()<=2){
            char lastChar = answer.charAt(answer.length()-1);
            while(answer.length()<3){
                answer += lastChar;
            }
        }

        return answer;   
    }
}