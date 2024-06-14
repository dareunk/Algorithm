import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int[][] indexDigit = new int[files.length][2];
        
        TreeMap<String, ArrayList<Integer>> map = new TreeMap<>();
        
        // number의 index 구함
        for(int i=0;i<files.length;i++){
            for(int j=0;j<files[i].length();j++){
                if(indexDigit[i][0]==0 && Character.isDigit(files[i].charAt(j))){
                    indexDigit[i][0] = j;
                }
                if(Character.isDigit(files[i].charAt(j))) indexDigit[i][1] = j;
                if(indexDigit[i][1]!=0 && !Character.isDigit(files[i].charAt(j))) break;
            }
        }

        for(int i=0;i<files.length;i++){
            String head = files[i].substring(0, indexDigit[i][0]);
            head = head.toLowerCase();
            if(map.containsKey(head)) map.get(head).add(i);
            else{
              map.put(head,new ArrayList<>());
              map.get(head).add(i);
            } 
        }
        
        // 순서가 보장되어야 함
        LinkedHashMap<Integer, Integer> map2= new LinkedHashMap<>();
        
        // ArrayList가 2개 이상인 경우에는 number 기준으로 정렬 + 답 반환
        int arrayIndex= 0;
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                int i=0;
                
                while(i<map.get(key).size()){
                    int index = map.get(key).get(i);
                    String number = files[index].substring(indexDigit[index][0], indexDigit[index][1]+1);
                    int num = Integer.parseInt(number);
                    map2.put(map.get(key).get(i), num);
                    i++;
                }
                List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map2.entrySet());
                list.sort(Map.Entry.comparingByValue());
		        for(Map.Entry<Integer, Integer> entry : list) {
			        answer[arrayIndex++] = files[entry.getKey()];
		        }
                map2 = new LinkedHashMap<>();
            }else{
                answer[arrayIndex++] = files[map.get(key).get(0)];
            }
        }

        return answer;
    }
    
}