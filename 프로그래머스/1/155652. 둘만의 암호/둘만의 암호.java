import java.util.HashSet;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0;i<skip.length();i++) set.add(skip.charAt(i));
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            for(int j=0;j<index;){
                
                temp = (char)(temp + 1);
                if(temp>'z') temp='a';
                if(set.contains(temp)) continue;
                j++;
            }
            answer += temp;
        }
        
        return answer;
    }
}