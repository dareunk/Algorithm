import java.util.Stack;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.isEmpty()) return "";
        answer = processValidation(p);
        return answer;
    }
    public String processValidation(String s){
        int leftSize = 0; int rightSize = 0;
        String u = ""; String v = "";
        String answer = "";
        Stack<Character> box = new Stack<>();
        int index =0; 
        
        while(true){
            // null이라면 return
            if(s.isEmpty() || index >= s.length()) return "";
            
            if(s.charAt(index) == '('){
                box.add('(');
                leftSize++;
            }else{
                if(!box.isEmpty()) box.pop();
                rightSize++;
            }
            index++;
            // stack이 비어있다면 올바른 문자열 
            // stack이 비어있지 않고 (와 )수가 같다면 균형잡힌 문자열
           
            if((leftSize == rightSize)){
                u = s.substring(0, index);
                v = s.substring(index, s.length());
                if(!box.isEmpty()) {
                    u = modifyStringForValidation(u);
                    return "(" + processValidation(v) + ")" + u;
                }else{
                    return u + processValidation(v);
                }
                
                  
               
            }
            
        }
    }
    public String modifyStringForValidation(String u){
     
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<u.length()-1; i++){
            char c = u.charAt(i);
            switch(c){
                    case '(' -> sb.append(")");
                    case ')' -> sb.append("(");
            }  
        }
        
        return sb.toString();
        
    }
    
}