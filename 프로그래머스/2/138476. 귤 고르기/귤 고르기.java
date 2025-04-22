import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1,o2) -> map.get(o2) - map.get(o1));
        int sum = k;
        for(int i : list){
            if(sum <= 0) break;
            sum -= map.get(i);
            answer++;
        }
        return answer;
    }
}