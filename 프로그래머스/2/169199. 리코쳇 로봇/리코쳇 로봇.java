import java.util.*;

class Solution {
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    static class board{
        int x; int y; int depth;
        public board(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth; 
        }
    }
    public int solution(String[] board) {
        // 'D'나 가장자리까지 부딪히기 전까지는 계속 움직임
        visited = new boolean[board.length][board[0].length()];
        board start = null;
        board goal = null;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R') start = new board(i,j,0);
                else if(board[i].charAt(j) == 'G') goal = new board(i,j,0);
            }
        }
        int answer = bfs(board, start, goal);

        return answer;
    }
    public static int bfs(String[] boards, board start, board goal){
        Queue<board> q = new LinkedList<board>();
        q.offer(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
             board p = q.poll();
             if(p.x == goal.x && p.y == goal.y) return p.depth;
             for(int i=0;i<4;i++){
                 int nx = p.x;
                 int ny = p.y;
                 
                 while(nx>=0&&nx<boards.length&&ny>=0&&ny<boards[0].length()&&boards[nx].charAt(ny) != 'D'){
                     nx += dx[i];
                     ny += dy[i];
                 }
                 
                 nx -= dx[i]; ny -= dy[i];
                 if(visited[nx][ny] || (p.x == nx && p.y == ny)) continue;
                 visited[nx][ny] = true;
                 q.offer(new board(nx, ny, p.depth+1));
             }
        }
        return -1;
    }
}
