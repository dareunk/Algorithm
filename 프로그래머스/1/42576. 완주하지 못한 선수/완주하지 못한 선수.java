import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 리스트로 간단하게 풀 수 있지만 시간초과 발생 
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String name : completion) map.put(name, map.getOrDefault(name,1)+1);
        
        for(String name : participant){
            if(map.containsKey(name)) map.replace(name,map.get(name)-1);
            if(!map.containsKey(name)||map.get(name) == 0) answer = name;
        }
        return answer;
    }
}