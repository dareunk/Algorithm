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
    static int[][] PIC;
    static int M;
    static int N;
    static int max = 0;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        PIC=picture;
        M=m;
        N=n;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] > 0) set.add(picture[i][j]);
            }
        }
        for(Integer k : set){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dfs(i,j,k.intValue());    
                    if(max > maxSizeOfOneArea) maxSizeOfOneArea = max;
                    if(max>0) numberOfArea++;
                    max =0;
                }
            }      
        }
      
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void dfs(int x, int y, int target){
        if(x<0 || x>=M || y<0 || y>=N) return;
        if(visited[x][y] || PIC[x][y]!=target) return;
        
        visited[x][y] = true;
        max++;
        dfs(x+1,y,target);
        dfs(x, y+1,target);
        dfs(x-1, y, target);
        dfs(x, y-1, target);
    }
}