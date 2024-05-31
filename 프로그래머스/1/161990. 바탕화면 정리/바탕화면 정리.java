class Solution {
    public int[] solution(String[] wallpaper) {
    
        // 파일이 있는 칸 : .
        // 파일이 없는 칸 : #
        
        // 맨 위쪽, 맨 왼쪽, 맨 아래, 맨 오른쪽 순 반환  
        int top;
        for(top=0;top<wallpaper.length;top++){
            if(wallpaper[top].contains("#")) break;
        }
        
        int left=wallpaper[0].length();
        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].contains("#")){
                if(wallpaper[i].indexOf("#") < left) left = wallpaper[i].indexOf("#");
            } 
        }
 
        int bottom;
        for(bottom=wallpaper.length-1;bottom>=0;bottom--){
            if(wallpaper[bottom].contains("#")) break;
        }
        
        int right=0;
        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].contains("#")){
                if(wallpaper[i].lastIndexOf("#") > right) right= wallpaper[i].lastIndexOf("#");
            }
        }
        int[] answer;
   // 파일이 아예 존재하지 않는 경우 
        if((top==wallpaper.length)&&(left==wallpaper.length)&&(bottom<0)&&(right==0)) answer = new int[]{0,0,0,0};
        else answer = new int[]{top,left,(bottom+1),(right+1)};
       
        return answer;
    }
}