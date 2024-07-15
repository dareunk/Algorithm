class Solution {
    int[][] quad;
    int[] answer = {0,0};
    public int[] solution(int[][] arr) {

        quad = arr;
        int size = arr.length;
        compression(0,0,size);
        return answer;
    }
    public boolean isCompression(int x, int y, int value, int size){
        
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(quad[i][j] != value) return false;
            }
        }
        return true;
    }
    public void compression(int x, int y, int size){
        
        if(isCompression(x,y, quad[x][y],size)){
            answer[quad[x][y]] += 1;
            return;
        }
        
        compression(x,y,size/2);
        compression(x,y+size/2,size/2);
        compression(x+size/2,y,size/2);
        compression(x+size/2, y+size/2, size/2);
    }
}