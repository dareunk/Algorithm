import java.util.LinkedHashMap;
import java.util.regex.*;
import java.util.ArrayList;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> playingMap = new LinkedHashMap<>();
        
        // 음악이 여러 개인 경우에는 재생 시간이 긴 음악 제목을 반환 
        for(String musicinfo : musicinfos){
            
            String[] info = musicinfo.split(",");
            String [] startTime = info[0].split(":");
            String [] endTime = info[1].split(":");
            int endHour = Integer.parseInt(endTime[0]); int endMin = Integer.parseInt(endTime[1]);
            int startHour = Integer.parseInt(startTime[0]); int startMin = Integer.parseInt(startTime[1]);
            int playingTime = (endHour*60+endMin) - (startHour*60+startMin);
            
            int playingSongLength = 1;
            String lyric="";
           
            info[3] = info[3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
            
            if(playingTime >= info[3].length()) {
                playingSongLength = playingTime / info[3].length();
                for(int i=0;i<playingSongLength;i++) lyric += info[3];
            }
            int unitLength = playingTime % info[3].length();
            String unitLyric = info[3].substring(0,unitLength);
            lyric += unitLyric;
            
          
            if(!map.containsKey(lyric)) {
                map.put(lyric, info[2]);
                playingMap.put(info[2], playingTime);
            }
            else{
                // 노래 길이가 같은 경우에는 playingTime이 긴 곡을 넣어줌
               if(playingMap.get(map.get(lyric)) < playingTime) {
                   map.put(lyric,info[2]);
                   playingMap.put(info[2], playingTime);
               }
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        m = m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
        String standard = ".*(" + m + ").*";
   
        // # 처리
   
        
        
        for(String key : map.keySet()){
            
            boolean isSameSong = Pattern.compile(standard).matcher(key).find(); 
            if(isSameSong) list.add(map.get(key)); // 노래 제목을 저장
    
        }
        
        if(list.size()==0) return "(None)";
        else if(list.size() == 1) answer = list.get(0);
        else{
            int max = playingMap.get(list.get(0));
            answer =list.get(0);
            for(int i=1; i< list.size();i++){
                if(playingMap.get(list.get(i)) > max) {max = playingMap.get(list.get(i)); answer =list.get(i);} 
            }
        }
        
        return answer;
    }
}