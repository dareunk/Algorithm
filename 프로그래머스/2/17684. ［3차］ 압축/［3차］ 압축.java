import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // linkedHashMap을 이용할 수도 있겠지만, 그냥 lastIndex를 따로 설정해서 hashmap 이용
    static HashMap<String, Integer> dictionary = new HashMap<>(); 
    public int[] solution(String msg) {
      
         List<Integer> list = new ArrayList<>();
        
        // 초기 dictionary 설정
        int number = (int)'A';
        for(int index=0;index<26;index++){
            char temp = (char)(number+index);
            dictionary.put(Character.toString(temp), index+1);     
        }
        
        int lastIndex = 26;
        int start=0;
        int end=1;
        
        while(end<=msg.length()){
            int[] position = findNewStringInDictionary(msg, start, end);
             
            // 문자열의 마지막까지 도달하면 값을 추가 후 반복문에서 벗어남 
            if(position[1] == -1 ){
                list.add(dictionary.get(msg.substring(position[0],msg.length())));
                break;
            }
            
            String newKey = msg.substring(position[0], position[1]);
            list.add(dictionary.get(msg.substring(position[0],position[1]-1)));
            dictionary.put(newKey,++lastIndex);
            start = position[1]-1;
            end = start+1;
        }
       
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
    static int[] findNewStringInDictionary(String msg, int start, int end){
        int i = 0;
        while(true){
            String key = msg.substring(start, end);
            if(!dictionary.containsKey(key)) break;
            else if(end == msg.length()) { end = -1; break; }
            else end++;
        }
        int[] result = {start, end};
        return result;
    }
 
}