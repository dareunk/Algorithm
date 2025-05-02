// 영역: 상하좌우로 연결된 같은 색의 공간
// 넓이: 각 칸을 더한 값
// 0은 포함을 안 시킴
// Hashset을 통해 중복되지 않는 각 영역의 숫자값 도출(target)
// dfs로 구현
// visited[m][n]을 방문하지 않은 경우
// depth 증가
// 만약 다른 숫자라면 return
// main 함수에서 dfs 함수 호출하고 return 된 횟수 => 영역의 횟수
// main 함수에서 dfs 함수 호출하고 return 된 숫자 중 가장 큰 수 => 가장 큰 영역의 넓이 
import java.util.*;
import java.util.stream.*;
class Solution {
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
     
        for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && picture[i][j] > 0){
                        int max = dfs(picture, m, n, i, j, picture[i][j]);
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
                        numberOfArea++;
                    }    
                }
        }      
        
      
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int dfs(int[][] picture, int m, int n, int x, int y, int target){
        if(x<0 || x>=m|| y<0 || y>=n) return 0;
        if(visited[x][y] || picture[x][y]!=target) return 0;
        
        visited[x][y] = true;
        int size = 1;
        size+=dfs(picture,m,n, x+1,y,target);
        size+=dfs(picture,m,n,x, y+1,target);
        size+=dfs(picture,m,n,x-1, y, target);
        size+= dfs(picture,m,n,x, y-1, target);
        return size;
    }
}