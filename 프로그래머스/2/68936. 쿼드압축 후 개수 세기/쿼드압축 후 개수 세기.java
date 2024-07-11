import java.util.Arrays;
class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        Arrays.fill(answer,0);
        // size가 1인 경우 종료시킴
        // size*size의 개수와 0또는 1의 개수가 같으면 압축
        int size = arr.length;
        compression(0,0,arr,size);
        return answer;
    }
    public boolean isCompression(int x, int y, int[][] arr, int size, int val){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j] != val) return false;
            }
        }
        return true;
    }
    public void compression(int x, int y, int[][] arr, int size){
        
        if(isCompression(x,y,arr,size, arr[x][y])){
            answer[arr[x][y]]+=1;
            return;
        }
       
        //좌위
        compression(x,y,arr,size/2);
        //우위
        compression(x,y+size/2,arr,size/2);
        //좌아
        compression(x+size/2,y,arr,size/2);
        //우아
        compression(x+size/2, y+size/2, arr, size/2);
        
    }
}