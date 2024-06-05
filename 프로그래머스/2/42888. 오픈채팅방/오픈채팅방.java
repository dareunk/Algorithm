import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        // HashMap에 각 아이디에 대한 최종적인 nickname 상태를 저장
        int arraySize =0;
        HashMap<String, String> map = new HashMap<>();
        for(String state: record){
            String[] temp = state.split(" ");
            if(!temp[0].equals("Change")) arraySize++;
            if(temp.length==3) map.put(temp[1],temp[2]);
            else continue;
        }
        
        String[] answer = new String[arraySize];
        
        int index=0;
        for(String state: record){
            String[] temp = state.split(" ");
            String message="";
            if(temp[0].equals("Enter")) message = "님이 들어왔습니다.";
            else if(temp[0].equals("Change")) continue;
            else message = "님이 나갔습니다.";
            answer[index++] = map.get(temp[1]) + message;
        }
        
        return answer;
        
        
    }
}