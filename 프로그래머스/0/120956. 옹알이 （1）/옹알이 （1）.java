class Solution {
    public int solution(String[] babbling) {
        // 할 수 있는 단어
        String[] vocabulary = {"aya", "ye", "woo", "ma"}; 
        
        // 만약 같은 단어가 있다면 지워버림.
        // 남아 있으면 머쓱이가 발음할 수 없는 단어가 들어있는 것.
        // 빈 문자열이면 머쓱이가 발음할 수 있는 단어로만 구성된 것.
        int answer = 0;
        for(int i=0;i<babbling.length;i++){
          String word =  babbling[i];
          for(int j=0;j<vocabulary.length;j++){
             // 최대 한 번이니까 replaceAll 말고 replace
             word = word.replace(vocabulary[j], "_");
             
          }
         word = word.replace("_","");
         if(word.isEmpty()) answer++;
        
        }
        
       
        return answer;
    }
}