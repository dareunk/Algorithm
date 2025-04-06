import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 1. 선물을 주고받은 기록이 있는 경우: 선물을 더 많이 준 사람이 선물받음
        // 2. gift score = sent gift - given gift 가 더 큰 경우
        // 3. gift score도 같은 경우에는 선물을 주고 받지 않음
        
        // return: 선물을 가장 많이 받을 친구의 선물의 수 
        
        
        // 선물 받은 기록
        // 이차원 배열로 기록
        // 행: 선물 준 기록, 열: 선물 받은 기록
        int[] finalScore = new int[friends.length];
        int[][] gift = new int[friends.length][friends.length];
        List<String> list = Arrays.asList(friends);
        
        for(int i=0;i<gifts.length;i++){
            String[] info = gifts[i].split(" ");
            gift[list.indexOf(info[0])][list.indexOf(info[1])]++;
        }
        //System.out.println(Arrays.deepToString(gift));
        
        int[] giftScore = new int[friends.length];
        for(int i=0;i<friends.length;i++){
            int sent = 0;
            int given = 0;
            for(int j=0;j<friends.length;j++){
                sent += gift[i][j];
                given += gift[j][i];
            }
            giftScore[i] = sent - given;
        }
        
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                if(i==j) continue; // 열과 행이 같다면 pass
                // case1 : 선물을 더 많이 준 경우 
                if(gift[i][j] > gift[j][i]) finalScore[i]++;
                else if(gift[i][j] == gift[j][i]){
                    if(giftScore[i] > giftScore[j]) finalScore[i]++;
                }
            }
        }
        
        // finalScore이 가장 큰 값만 반환
        Arrays.sort(finalScore);
        answer = finalScore[finalScore.length-1];
        return answer;
    }
}