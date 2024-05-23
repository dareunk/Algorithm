import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
      
    // 맵 생성
     HashMap<String,Integer> map = new HashMap<String,Integer>();
     for(int i=0;i<players.length;i++){
         map.put(players[i], i);
     }
        
     for(String calling: callings){
         int location = map.get(calling);
         
         if(location>0){
         int frontlocation = location-1;
         
        String temp = players[frontlocation];
                
            // 자리 교체
            players[frontlocation] = calling;
            players[location] = temp;  
        // 맵 정보 교체
             map.replace(calling,frontlocation);
             map.replace(temp,location);
         }else continue;

         
     }
        
    answer = players;

      return answer;
    }
}
