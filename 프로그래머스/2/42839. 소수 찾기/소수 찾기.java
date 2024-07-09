import java.util.*;

class Solution {
    // 중복을 처리해줘야함 -> set 자료구조 이용
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    public static int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        Arrays.fill(visited,false);
        
        String[] numberArr = numbers.split("");
        DFS(numberArr, 0, "");
        
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    public static boolean isPrime(int num){
        
        if(num<2) return false;
        for(int i=2;i<=((int)Math.sqrt(num));i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void DFS(String[] nums, int depth, String s){

        if(depth >= nums.length) return;
        for(int i=0;i<nums.length;i++){
            if(visited[i] == false){
               visited[i] = true;
               set.add(Integer.parseInt(s+nums[i]));
               DFS(nums, (depth+1), (s+nums[i]));
               visited[i] = false;
           }
        }
    }   
}