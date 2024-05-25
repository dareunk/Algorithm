import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        int[] reportedNumber = new int[id_list.length]; 

        
        // 중복 처리가 필요(같은 신고에 대해서는 무시함)
        // list로 contain해서 찾으니까 시간복잡도 O(n)
        /*
        List<String> reportArray = new ArrayList<>();
        
        for(String name: report){
            if(!reportArray.contains(name)) reportArray.add(name);
        }
        */
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String name: report){
            map.put(name, 0);
        };
        
        
        int count=1; 
        // 전체 reported 된 횟수 구하기 
        for(String name: map.keySet()){
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
        
        for(String name : map.keySet()){
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