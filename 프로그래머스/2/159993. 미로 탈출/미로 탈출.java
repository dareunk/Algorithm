import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Position{
    int x, y;
    int count;
    Position(int x,int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    
   
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        // 최단 경로 -> bfs
        // 출발 지점에서 레버로 이동하는 최소 경로 + 레버에서 출구로 이동하는 최소 경로
        int total = 1;
        int[] start={-1,-1}; int[] lever = {-1,-1}; int[] end = {-1,-1};
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j) == 'S') {start[0]=i; start[1]=j;}
                if(maps[i].charAt(j) == 'L') {lever[0]=i; lever[1]=j;}
                if(maps[i].charAt(j) == 'E') {end[0]=i; end[1]=j;}
                map[i][j] = maps[i].charAt(j);
            }
        }
        
       int result1 = BFS(start,lever, maps.length, maps[0].length());
       if(result1 == -1) return -1;
       // 여러 번 지날 수 있으므로, visited 정보 초기화시켜줌
       visited = new boolean[maps.length][maps[0].length()];
       int result2 = BFS(lever, end, maps.length, maps[0].length());
       if(result2 == -1) return -1;
       answer = result1 + result2;
       return answer;
    }
    
    static int BFS(int[] start, int[] end, int height, int width){
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(start[0],start[1],0));
        visited[start[0]][start[1]] = true;
        
        while(!que.isEmpty()){
             Position current = que.poll();
             if(current.x == end[0] && current.y == end[1]) return current.count;
             
             for(int i=0;i<4;i++){
                 int currentX = current.x + dx[i];
                 int currentY = current.y + dy[i];
                 
                 if(currentX>=0 && currentX<height && currentY >=0 && currentY< width){
                     if((map[currentX][currentY] != 'X') && (!visited[currentX][currentY])){
                         visited[currentX][currentY] = true;
                         que.add(new Position(currentX,currentY,current.count+1));
                     }
                 }
                 else continue;
             }
        }
        return -1;
    }       
}