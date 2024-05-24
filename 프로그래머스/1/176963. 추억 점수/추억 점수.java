import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int totalLength = photo.length;
        int[] answer = new int[totalLength];
        
        // 각 인물의 보상점수 map 형성
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        int totalYearning = 0;
        int index=0;
        
        for(String[] people : photo){
            for(int i=0;i<people.length;i++){
               if(map.containsKey(people[i])) totalYearning += map.get(people[i]);
            }
            answer[index] = totalYearning;
            // 초기화
            totalYearning=0;
            index++;
        }
        
        
        return answer;
    }
}