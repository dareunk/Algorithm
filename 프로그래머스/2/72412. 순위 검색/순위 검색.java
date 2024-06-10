import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 관점 : 몇 가지 항목이 빈칸으로 제출되면 모두 해당된다는 뜻
        int mapIndex=0;
        for(String user : info){
            String[] temp = user.split(" ");
            int value = Integer.parseInt(temp[4]);
            putAllInfoInMap(temp, "", 0, value);
           
        }
        for(String key : map.keySet()) Collections.sort(map.get(key));
        
        int[] answer = new int[query.length];
        int index=0;
        
        for(String rules : query){
            rules = rules.replace("and","");
            rules = rules.replace("-", "");
            rules = rules.replaceAll("\\s+", " ");
            rules = rules.trim();
            String[] rule = rules.split(" ");
            
            int endIndex = rule.length;
            String ruleInfo = "";
            int score = 0;
            if(rule[rule.length-1].matches(".*[0-9].*")){
                score = Integer.parseInt(rule[rule.length-1]);
                endIndex = rule.length-1;
            }
            for(int i=0;i<endIndex;i++) ruleInfo += rule[i];
            
            // 순차 탐색을 하다보니 전반적으로 속도가 느림
            // 이진 탐색 설정
            answer[index] = binarySearch(ruleInfo, score);
            index++; 
    }
        
        return answer;
    }
    static void putAllInfoInMap(String[] info, String str, int depth, int value){
        if(depth == 4){
            if(map.containsKey(str)){
                map.get(str).add(value);
            }
            else{
                map.put(str, new ArrayList<>());
                map.get(str).add(value);
            }
            return;
        }
        putAllInfoInMap(info, str+"", depth+1,value);
        putAllInfoInMap(info, str+=info[depth], depth+1, value);
    }
    
    static int binarySearch(String query, int key){
        ArrayList<Integer> list = map.get(query);
        if(!map.containsKey(query)) return 0;
        int low = 0;
        int high = list.size()-1;
        int middle;
        while(low <= high){
            middle = (low+high)/2;
            if(list.get(middle) < key) low = middle+1;
            else high = middle-1;
        }
        return list.size() - low;
    }
}