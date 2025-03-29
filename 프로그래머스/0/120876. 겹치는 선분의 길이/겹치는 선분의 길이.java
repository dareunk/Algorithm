class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] dots = new int[200];
        
        for(int i=0;i<lines.length;i++){
            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;
            
            for(int j=start;j<end;j++) dots[j]+=1;
        }
        
        for(int i=0;i<dots.length;i++) if(dots[i] > 1) answer++;
        return answer;
    }
}