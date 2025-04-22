import java.util.*;

class Solution {
    static String[] MAPS;
    static List<Integer> list = new LinkedList<>();
    static boolean[][] visited;
    static int sum=0;
    public int[] solution(String[] maps) {
        int[] answer = {};
        MAPS=maps;
        visited = new boolean[maps.length][maps[0].length()];
        for(int x=0;x<maps.length;x++){
            for(int y=0;y<maps[x].length();y++){
                dfs(x,y);
                if(sum>0) list.add(sum);
                sum =0; 
            }
        }
        if(list.size() == 0) answer = new int[]{-1};
        else{
            Collections.sort(list);
            answer = list.stream().mapToInt(i->i).toArray();
        }
        return answer;
    }
    public static void dfs(int x, int y){
        if(x<0 || y<0 || x>=MAPS.length || y>= MAPS[0].length()) return;
        if( MAPS[x].charAt(y) == 'X' || visited[x][y] ) return;
        else{
            visited[x][y] = true;
           // sum += MAPS[x].charAt(y) - '0';
            sum+= Character.getNumericValue(MAPS[x].charAt(y));
        }
        dfs(x, y+1);
        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y-1);
    }
} 