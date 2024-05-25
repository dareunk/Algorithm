import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        int[] reportedNumber = new int[id_list.length]; 

        
        // 중복 처리가 필요(같은 신고에 대해서는 무시함)
        // list로 contain해서 찾으니까 시간복잡도 O(n)
        // -> 이런 경우에는 linkedHashSet이나 stream의 distinct를 이용하는 것이 좋음 
        
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(report));
        
       
        
        int count=1; 
        // 전체 reported 된 횟수 구하기 
        for(String name: linkedHashSet){
            String[] tempName = name.split(" ");
            
            String reporter = tempName[0];
            String reported = tempName[1];
            
            
            int index = Arrays.asList(id_list).indexOf(reported);
            reportedNumber[index] += count;
       
        }
        
        // k 이상인 사용자 구하기
        List<String> suspendedUser = new ArrayList<>();
       
        for(int i=0;i<reportedNumber.length;i++){
            if(reportedNumber[i] >= k){
                 suspendedUser.add(id_list[i]);
           }
        }
        
        for(String name : linkedHashSet){
            String[] tempName = name.split(" ");
            String reporter = tempName[0];
            String reported = tempName[1];
            
            if(suspendedUser.contains(reported)){
                answer[Arrays.asList(id_list).indexOf(reporter)] += count;
            }
        }
        return answer;
    }
}