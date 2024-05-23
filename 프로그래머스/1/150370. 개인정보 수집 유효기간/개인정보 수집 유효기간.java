import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
       // int[] answer = {};
        
        // 모든 달 28일까지 있음
        
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        
        for(int i=0; i<terms.length;i++){
            String[] tempTerm = terms[i].split(" ");
            int validPeriod = Integer.parseInt(tempTerm[1]);
            
            map.put(tempTerm[0],validPeriod);
        }
        
        
        int number=1;
        int index=0;
        String tempString = new String();
        
        for(String privacy: privacies){
            String[] array = privacy.split(" ");
            
            int validPeriod = map.get(array[1]);
            /*
            int validPeriodDay = validPeriod * 28;
            int validPeriodMonth = validPeriodDay/28;
            int validPeriodDate = validPeriodDay%28;
            */
            
            // 기준 날짜 
            int[] date = Arrays.stream(array[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            int year = date[0];
            /*
            int month = (date[1] + validPeriod);
            if(month > 12){
                int temp = month;
                month = temp % 12;
                // 만약 2바퀴를 돌고 다시 돌아오는 경우 
                if(month == 0) month = 12; 
                year = year + (temp/12);
            }*/
            int month = date[1];
            if(validPeriod >= 12){
                year = year + (validPeriod / 12);
                month = month + (validPeriod % 12);
            }else{
                month = month + validPeriod;
            }  
            
            
            if( month > 12){
                int tempMonth = month;
                month = tempMonth % 12;
                year = year + (tempMonth/12);
            }
            int day = date[2];
            
            int[] todays = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
            
            if(year-todays[0]<=0){
                if(year-todays[0]<0){
                    tempString += (number+ " ");
                   
                }else{
                    if(month-todays[1]<0){
                        tempString += (number+ " ");
                        
                    }
                    else if(month == todays[1]){
                        if(day-todays[2]<=0){
                            tempString += (number+ " ");
                        }
                    }
                }
                
            }
            
            number++;
   
        }
        
        // 배열로 저장하기
        
        String[] answerString = tempString.split(" ");
        int indexOfArray = answerString.length;
        int[] answer = new int[indexOfArray];
        if(indexOfArray > 0){
        for(int i=0;i<indexOfArray;i++){
            answer[i] = Integer.parseInt(answerString[i]);
        }       
        }
       
     
      
     
        
        return answer;
    }
}