import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int m, int[] score) {
        // k : 사과의 최대 점수
        // m : 한 상자에 들어가는 사과의 수
        // score: 사과의 점수
        
        // 최대값부터 내림차순 정렬
        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[] :: new);
        Arrays.sort(scores,Comparator.reverseOrder());
        
        int totalScore = 0;
        
        for(int i=0; i<scores.length; i++){
            if((i+1)% m == 0) totalScore += (scores[i] * m);
        }
        
        int answer = totalScore;
        return answer;
    }
}