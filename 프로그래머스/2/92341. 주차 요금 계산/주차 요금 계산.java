import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 입차 이후 출차 기록 없으면 23:59 출차 간주
        // 차량번호가 작은 순 return -> TreeMap 이용
        TreeMap<String,Integer> map = new TreeMap<>();
        HashMap<String, Integer> countingMap = new HashMap<>();
        
        int count=0;
        
        for(String record : records){
            String[] car = record.split(" ");
            String[] times = car[0].split(":");
            int time = Integer.parseInt(times[1]) + (Integer.parseInt(times[0])*60);
            
            if(car[2].equals("IN")) time = time * (-1);
            
            map.put(car[1],map.getOrDefault(car[1],0)+time);
            countingMap.put(car[1],countingMap.getOrDefault(car[1],0)+1);
            
        }
    
        int[] answer= new int[map.size()];
        int index=0;
        for(String car : map.keySet()){
            // 출차 기록이 없는 경우 + 23:59 
            int totaltime = 0;
            if(countingMap.get(car)%2!=0){
                int time = 23*60 + 59;  
                totaltime = map.get(car) + time;
            }else totaltime = map.get(car);
            
            if(totaltime<=fees[0]) { answer[index++] = fees[1];}
            else {
                int parkingfee = fees[1] + (int)Math.ceil((totaltime-fees[0])/(double)fees[2])*fees[3];
                answer[index++] = parkingfee;
            }
        }
        
        return answer;
    }
}