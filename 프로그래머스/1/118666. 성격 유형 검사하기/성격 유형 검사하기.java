import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 1 -> 비동의, 2-> 동의
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i=0;i<survey.length;i++){
            
            int score=0;
            char type;
            switch(choices[i]){
                case 1,7->score=3;
                case 2,6->score=2;
                case 3,5->score=1;
                case 4 -> score=0;
             }
            if(choices[i]>4) type = survey[i].charAt(1);
            else type = survey[i].charAt(0);
            
           
                int temp = map.get(type);
                temp += score;
                map.replace(type,temp);
           
        }
        
        answer += map.get('R') < map.get('T')?"T":"R";
        answer += map.get('C') < map.get('F')?"F":"C";
        answer += map.get('J') < map.get('M')?"M":"J";
        answer += map.get('A') < map.get('N')?"N":"A"; 
        
        return answer;
    }
}