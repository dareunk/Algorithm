import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 입차 이후 출차 기록 없으면 23:59 출차 간주
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> countingMap = new HashMap<>();
        
        int count=0;
        
        for(String record : records){
            String[] car = record.split(" ");
            String[] times = car[0].split(":");
            int time = Integer.parseInt(times[1]) + (Integer.parseInt(times[0])*60);
            
            if(car[2].equals("IN")) time = time * (-1);
            
            if(!map.containsKey(car[1])) {map.put(car[1],time); countingMap.put(car[1],1);}
            else{
                int temp = map.get(car[1]);
                temp = temp + time;
                map.replace(car[1],temp);
                countingMap.replace(car[1], countingMap.get(car[1])+1);
            }
        }
        ArrayList<Integer> tempList = new ArrayList<>();
  
        // 차량번호가 작은 순
        TreeMap<String,Integer> sortedMap = new TreeMap<>(map);
        
        for(String car : sortedMap.keySet()){
            // 출차 기록이 없는 경우 + 23:59 
            int totaltime = 0;
            if(countingMap.get(car)%2!=0){
                int time = 23*60 + 59;  
                totaltime = map.get(car) + time;
            }else totaltime = map.get(car);
            
            if(totaltime<=fees[0]) {tempList.add(fees[1]); continue;}
            else {
                int parkingfee = fees[1] + (int)Math.ceil((totaltime-fees[0])/(double)fees[2])*fees[3];
                tempList.add(parkingfee);
            }
        }
        
        int[] answer= new int[tempList.size()];
        int i=0;
        for(int number:tempList) answer[i++] = number;
        
        return answer;
    }
}