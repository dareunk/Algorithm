class Solution {
    public int[] solution(int n) {
       
        // 전체 칸 구하기 
        int size = n*(n+1) / 2;
        int[] answer = new int[size];
        
        //아래 -> 오른쪽 -> 대각선(반복)
        
        int[][] snail = new int[n][n];
        
        int x = -1;
        int y = 0;
        int number = 1;
        // 1칸씩 줄어듦
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                // i와, j 는 횟수를 나타내는 지표
                // x,y가 실질적인 인덱스 역할
                
                if(i%3 == 0) x++; // 아래 이동
                else if(i%3 == 1) y++; // 오른쪽 이동
                else if(i%3 == 2) {x--; y--;}
                
                snail[x][y] = number++;
            }
        }
        int index =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(snail[i][j] == 0) break;
                answer[index++] = snail[i][j];
            }
        }
        return answer;
    }
}